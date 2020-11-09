package com.github.kotvertolet.youtubejextractor;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnit4;

import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.github.kotvertolet.youtubejextractor.models.AdaptiveAudioStream;
import com.github.kotvertolet.youtubejextractor.models.AdaptiveVideoStream;
import com.github.kotvertolet.youtubejextractor.models.subtitles.Subtitle;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.MuxedStream;
import com.github.kotvertolet.youtubejextractor.models.youtube.videoData.YoutubeVideoData;
import com.github.kotvertolet.youtubejextractor.network.YoutubeNetwork;
import com.google.gson.GsonBuilder;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Response;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class ExtractionTests extends TestCase {
    private YoutubeJExtractor youtubeJExtractor = new YoutubeJExtractor();
    private YoutubeNetwork youtubeNetwork = new YoutubeNetwork(new GsonBuilder().create());
    private YoutubeVideoData videoData;

    @Test(expected = ExtractionException.class)
    public void checkInvalidVideoId() throws YoutubeRequestException, ExtractionException {
        youtubeJExtractor.extract("invalid_id");
    }

    @Test
    public void checkVideoDataParcel() throws YoutubeRequestException, ExtractionException {
        String parcelKey = "parcel_key1";
        videoData = youtubeJExtractor.extract("rkas-NHQnsI");
        Bundle bundle = new Bundle();
        bundle.putParcelable(parcelKey, videoData);
        assertEquals(videoData, bundle.getParcelable(parcelKey));
    }

    @Test
    public void checkVideoWithEncryptedSignature() throws ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("xRioA3a6qgg");
        checkIfStreamsWork(videoData);
    }

    @Test
    public void checkVideoWithoutEncryptedSignature() throws ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("jNQXAC9IVRw");
        checkIfStreamsWork(videoData);
    }

    @Test
    public void checkVideoWithAgeCheck() throws ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("Pk0z3Aj3P5E");
        checkIfStreamsWork(videoData);
    }

    @Test
    public void checkVeryLongVideo() throws ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("85bkCmaOh4o");
        checkIfStreamsWork(videoData);
    }

    @Test
    public void checkVideoWithRestrictedEmbedding() throws ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("XcicOBS9mBU");
        checkIfStreamsWork(videoData);
    }

    @Test
    public void checkLiveStream() throws YoutubeRequestException, ExtractionException {
        videoData = youtubeJExtractor.extract("5qap5aO4i9A");
        assertTrue(videoData.getVideoDetails().isLiveContent());
        assertNotNull(videoData.getStreamingData().getDashManifestUrl());
        assertNotNull(videoData.getStreamingData().getHlsManifestUrl());
        checkIfStreamsWork(videoData);
    }

    //@Test
    public void checkLiveStreamWithoutAdaptiveStreams() throws YoutubeRequestException, ExtractionException {
        videoData = youtubeJExtractor.extract("up0fWFqgC6g");
        assertTrue(videoData.getVideoDetails().isLiveContent());
        assertNotNull(videoData.getStreamingData().getDashManifestUrl());
        assertNotNull(videoData.getStreamingData().getHlsManifestUrl());
        assertEquals(0, videoData.getStreamingData().getAdaptiveAudioStreams().size());
        assertEquals(0, videoData.getStreamingData().getAdaptiveVideoStreams().size());
    }

    @Test
    public void checkMuxedStreamNonEncrypted() throws YoutubeRequestException, ExtractionException {
        videoData = youtubeJExtractor.extract("8QyDmvuts9s");
        checkIfStreamsWork(videoData);
    }

    @Test
    public void checkCallbackBasedExtractionSuccessful() {
        youtubeJExtractor.extract("iIKxyDRjecU", new JExtractorCallback() {
            @Override
            public void onSuccess(YoutubeVideoData videoData) {
                checkIfStreamsWork(videoData);
            }

            @Override
            public void onNetworkException(YoutubeRequestException e) {
                fail("Network exception occurred");
            }

            @Override
            public void onError(Exception exception) {
                fail("Extraction exception occurred");
            }
        });
    }

    @Test
    public void testSubtitlesExtraction() {
        Map<String, ArrayList<Subtitle>> subs = youtubeJExtractor.extractSubtitles("lT3vGaOLWqE");
        assertEquals(8, subs.size());
        assertTrue(subs.containsKey("en"));
        List<Subtitle> englishSubs = subs.get("en");
        assertEquals(208, englishSubs.size());
        Subtitle actualFirstLine = englishSubs.get(0);
        Subtitle expectedFirstLine = new Subtitle("0.78", "0.56", "Hi. Shh.");
        Subtitle actualLasLine = englishSubs.get(207);
        Subtitle expectedLastLine = new Subtitle("620.22", "1.28", "#{{beatboxing}}#");
        assertEquals(expectedFirstLine, actualFirstLine);
        assertEquals(expectedLastLine, actualLasLine);
    }

    private void checkIfStreamsWork(YoutubeVideoData videoData) {
        String streamErrorMask = "Stream wasn't processed correctly, stream details:\\n %s";
        Response<ResponseBody> responseBody;
        try {
            if (videoData.getVideoDetails().isLiveContent()) {
                responseBody = youtubeNetwork.getStream(videoData.getStreamingData().getDashManifestUrl());
                assertNotNull(responseBody);
                assertTrue(responseBody.isSuccessful());
                responseBody = youtubeNetwork.getStream(videoData.getStreamingData().getHlsManifestUrl());
                assertNotNull(responseBody);
                assertTrue(responseBody.isSuccessful());
            } else {
                for (AdaptiveVideoStream adaptiveVideoStream : videoData.getStreamingData().getAdaptiveVideoStreams()) {
                    responseBody = youtubeNetwork.getStream(adaptiveVideoStream.getUrl());
                    assertThat(String.format(streamErrorMask, adaptiveVideoStream.toString()), responseBody, is(not(nullValue())));
                    assertThat(String.format(streamErrorMask, adaptiveVideoStream.toString()), responseBody.isSuccessful(), is(true));
                }
                for (AdaptiveAudioStream adaptiveAudioStream : videoData.getStreamingData().getAdaptiveAudioStreams()) {
                    responseBody = youtubeNetwork.getStream(adaptiveAudioStream.getUrl());
                    assertThat(String.format(streamErrorMask, adaptiveAudioStream.toString()), responseBody, is(not(nullValue())));
                    assertThat(String.format(streamErrorMask, adaptiveAudioStream.toString()), responseBody.isSuccessful(), is(true));
                }
                for (MuxedStream muxedStream : videoData.getStreamingData().getMuxedStreams()) {
                    responseBody = youtubeNetwork.getStream(muxedStream.getUrl());
                    assertThat(String.format(streamErrorMask, muxedStream.toString()), responseBody, is(not(nullValue())));
                    assertThat(String.format(streamErrorMask, muxedStream.toString()), responseBody.isSuccessful(), is(true));
                }
            }
        } catch (YoutubeRequestException e) {
            fail(e.getMessage());
        }
    }
}
package com.github.kotvertolet.youtubejextractor;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnit4;

import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.github.kotvertolet.youtubejextractor.models.AudioStreamItem;
import com.github.kotvertolet.youtubejextractor.models.VideoStreamItem;
import com.github.kotvertolet.youtubejextractor.models.youtube.videoData.YoutubeVideoData;
import com.github.kotvertolet.youtubejextractor.network.YoutubeSiteNetwork;

import org.junit.Test;
import org.junit.runner.RunWith;

import okhttp3.ResponseBody;
import retrofit2.Response;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class ExtractionTests {

    private YoutubeJExtractor youtubeJExtractor = new YoutubeJExtractor();
    private YoutubeSiteNetwork youtubeSiteNetwork = YoutubeSiteNetwork.getInstance();
    private YoutubeVideoData videoData;

    @Test(expected = ExtractionException.class)
    public void checkInvalidVideoId() throws YoutubeRequestException, ExtractionException {
        youtubeJExtractor.extract("invalid_id");
    }

    @Test(expected = ExtractionException.class)
    public void checkRegionRestrictedVideo() throws YoutubeRequestException, ExtractionException {
        youtubeJExtractor.extract("dfUyUPx7kpY");
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
        videoData = youtubeJExtractor.extract("kJQP7kiw5Fk");
        checkIfStreamsWork(videoData);
    }

    @Test
    public void checkVideoWithoutEncryptedSignature() throws ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("jNQXAC9IVRw");
        checkIfStreamsWork(videoData);
    }

    @Test
    public void checkVideoWithAgeCheck() throws ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("h3yFGoSkgk8");
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
        videoData = youtubeJExtractor.extract("hHW1oY26kxQ");
        assertTrue(videoData.getVideoDetails().isLiveContent());
        assertNotNull(videoData.getStreamingData().getDashManifestUrl());
        assertNotNull(videoData.getStreamingData().getHlsManifestUrl());
        checkIfStreamsWork(videoData);
    }

    private void checkIfStreamsWork(YoutubeVideoData videoData) throws YoutubeRequestException {
        String streamErrorMask = "Stream wasn't processed correctly, stream details:\\n %s";
        Response<ResponseBody> responseBody;
        for (VideoStreamItem videoStreamItem : videoData.getStreamingData().getVideoStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(videoStreamItem.getUrl());
            assertThat(String.format(streamErrorMask, videoStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(streamErrorMask, videoStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
        for (AudioStreamItem audioStreamItem : videoData.getStreamingData().getAudioStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(audioStreamItem.getUrl());
            assertThat(String.format(streamErrorMask, audioStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(streamErrorMask, audioStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
        if (videoData.getVideoDetails().isLiveContent()) {
            responseBody = youtubeSiteNetwork.getStream(videoData.getStreamingData().getDashManifestUrl());
            assertNotNull(responseBody);
            assertTrue(responseBody.isSuccessful());
            responseBody = youtubeSiteNetwork.getStream(videoData.getStreamingData().getHlsManifestUrl());
            assertNotNull(responseBody);
            assertTrue(responseBody.isSuccessful());
        }
    }
}

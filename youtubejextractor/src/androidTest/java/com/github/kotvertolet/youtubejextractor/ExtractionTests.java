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
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class ExtractionTests {

    private YoutubeJExtractor youtubeJExtractor = new YoutubeJExtractor();
    private YoutubeSiteNetwork youtubeSiteNetwork = YoutubeSiteNetwork.getInstance();
    private YoutubeVideoData videoData;
    private Response<ResponseBody> responseBody;
    private String errorMask = "Stream wasn't processed correctly, stream details:\\n %s";

    @Test(expected = ExtractionException.class)
    public void checkInvalidVideoId() throws YoutubeRequestException, ExtractionException {
        youtubeJExtractor.extract("invalid_id");
    }

    @Test
    public void checkStreamItemsParcel() throws YoutubeRequestException, ExtractionException {
        String parcelKey1 = "parcel_key1";
        String parcelKey2 = "parcel_key2";
        videoData = youtubeJExtractor.extract("rkas-NHQnsI");
        Bundle bundle = new Bundle();
        AudioStreamItem audioStreamItem = videoData.getStreamingData().getAudioStreamItems().get(0);
        VideoStreamItem videoStreamItem = videoData.getStreamingData().getVideoStreamItems().get(0);
        bundle.putParcelable(parcelKey1, audioStreamItem);
        bundle.putParcelable(parcelKey2, videoStreamItem);
        assertEquals(audioStreamItem, bundle.getParcelable(parcelKey1));
        assertEquals(videoStreamItem, bundle.getParcelable(parcelKey2));
    }

    @Test
    public void checkVideoWithEncryptedSignature() throws ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("kJQP7kiw5Fk");
        for (VideoStreamItem videoStreamItem : videoData.getStreamingData().getVideoStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(videoStreamItem.getUrl());
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
        for (AudioStreamItem audioStreamItem : videoData.getStreamingData().getAudioStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(audioStreamItem.getUrl());
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }

    @Test
    public void checkVideoWithoutEncryptedSignature() throws ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("jNQXAC9IVRw");
        for (VideoStreamItem videoStreamItem : videoData.getStreamingData().getVideoStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(videoStreamItem.getUrl());
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
        for (AudioStreamItem audioStreamItem : videoData.getStreamingData().getAudioStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(audioStreamItem.getUrl());
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }

    @Test
    public void checkVideoWithAgeCheck() throws ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("h3yFGoSkgk8");
        for (VideoStreamItem videoStreamItem : videoData.getStreamingData().getVideoStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(videoStreamItem.getUrl());
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
        for (AudioStreamItem audioStreamItem : videoData.getStreamingData().getAudioStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(audioStreamItem.getUrl());
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }

    @Test
    public void checkVeryLongVideo() throws ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("85bkCmaOh4o");
        for (VideoStreamItem videoStreamItem : videoData.getStreamingData().getVideoStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(videoStreamItem.getUrl());
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
        for (AudioStreamItem audioStreamItem : videoData.getStreamingData().getAudioStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(audioStreamItem.getUrl());
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }

    @Test
    public void checkVideoWithRestrictedEmbedding() throws ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("XcicOBS9mBU");
        for (VideoStreamItem videoStreamItem : videoData.getStreamingData().getVideoStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(videoStreamItem.getUrl());
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
        for (AudioStreamItem audioStreamItem : videoData.getStreamingData().getAudioStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(audioStreamItem.getUrl());
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }

    @Test
    public void checkAgeRestrictedVideo() throws ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("V_7CLYGdkps");
        for (VideoStreamItem videoStreamItem : videoData.getStreamingData().getVideoStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(videoStreamItem.getUrl());
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
        for (AudioStreamItem audioStreamItem : videoData.getStreamingData().getAudioStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(audioStreamItem.getUrl());
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }
}

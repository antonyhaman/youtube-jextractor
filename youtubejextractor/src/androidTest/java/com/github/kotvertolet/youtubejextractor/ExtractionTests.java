package com.github.kotvertolet.youtubejextractor;

import android.support.test.runner.AndroidJUnit4;

import com.github.kotvertolet.youtubejextractor.YoutubeJExtractor;
import com.github.kotvertolet.youtubejextractor.network.YoutubeSiteNetwork;
import com.github.kotvertolet.youtubejextractor.pojo.StreamItem;
import com.github.kotvertolet.youtubejextractor.pojo.youtubeInnerData.YoutubeVideoData;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class ExtractionTests {

    private YoutubeJExtractor youtubeJExtractor = new YoutubeJExtractor();
    private YoutubeSiteNetwork youtubeSiteNetwork = YoutubeSiteNetwork.getInstance();
    private YoutubeVideoData videoData;
    private Response<ResponseBody> responseBody;

    @Test
    public void checkVideoWithEncryptedSignature() throws IOException {
        videoData = youtubeJExtractor.extract("kJQP7kiw5Fk");
        for (StreamItem streamItem : videoData.getStreamingData().getStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(streamItem.getUrl());
            assertThat(String.format("Stream wasn't processed correctly, stream details:\n %s",
                    streamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }

    @Test
    public void checkVideoWithoutEncryptedSignature() throws IOException {
        videoData = youtubeJExtractor.extract("jNQXAC9IVRw");
        for (StreamItem streamItem : videoData.getStreamingData().getStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(streamItem.getUrl());
            assertThat(String.format("Stream wasn't processed correctly, stream details:\n %s",
                    streamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }

    @Test
    public void checkVideoWithAgeCheck() throws IOException {
        videoData = youtubeJExtractor.extract("h3yFGoSkgk8");
        for (StreamItem streamItem : videoData.getStreamingData().getStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(streamItem.getUrl());
            assertThat(String.format("Stream wasn't processed correctly, stream details:\n %s",
                    streamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }

    @Test
    public void checkVeryLongVideo() throws IOException {
        videoData = youtubeJExtractor.extract("85bkCmaOh4o");
        for (StreamItem streamItem : videoData.getStreamingData().getStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(streamItem.getUrl());
            assertThat(String.format("Stream wasn't processed correctly, stream details:\n %s",
                    streamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }
}

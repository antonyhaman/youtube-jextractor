package com.github.kotvertolet;

import android.support.test.runner.AndroidJUnit4;

import com.github.kotvertolet.network.YoutubeSiteNetwork;
import com.github.kotvertolet.pojo.StreamItem;
import com.github.kotvertolet.pojo.youtubeInnerData.YoutubeVideoData;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
            assertThat(responseBody.isSuccessful(), is(true));
        }
    }

    @Test
    public void checkVideoWithoutEncryptedSignature() throws IOException {
        videoData = youtubeJExtractor.extract("jNQXAC9IVRw");
        for (StreamItem streamItem : videoData.getStreamingData().getStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(streamItem.getUrl());
            assertThat(responseBody.isSuccessful(), is(true));
        }
    }

    @Test
    public void checkVideoWithAgeCheck() throws IOException {
        videoData = youtubeJExtractor.extract("h3yFGoSkgk8");
        for (StreamItem streamItem : videoData.getStreamingData().getStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(streamItem.getUrl());
            assertThat(responseBody.isSuccessful(), is(true));
        }
    }
}

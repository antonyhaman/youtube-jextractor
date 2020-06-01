package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import com.github.kotvertolet.youtubejextractor.models.youtube.videoData.VideoDetails;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PlayerResponse implements Serializable {

    private PlayerConfig playerConfig;
    private String trackingParams;
    private Attestation attestation;
    private VideoDetails videoDetails;
    @SerializedName("streamingData")
    private RawStreamingData rawStreamingData;
    private PlayabilityStatus playabilityStatus;
    private List<MessagesItem> messages;
    private PlaybackTracking playbackTracking;
    private Microformat microformat;
    private Storyboards storyboards;

    public PlayerConfig getPlayerConfig() {
        return playerConfig;
    }

    public void setPlayerConfig(PlayerConfig playerConfig) {
        this.playerConfig = playerConfig;
    }

    public String getTrackingParams() {
        return trackingParams;
    }

    public void setTrackingParams(String trackingParams) {
        this.trackingParams = trackingParams;
    }

    public Attestation getAttestation() {
        return attestation;
    }

    public void setAttestation(Attestation attestation) {
        this.attestation = attestation;
    }

    public VideoDetails getVideoDetails() {
        return videoDetails;
    }

    public void setVideoDetails(VideoDetails videoDetails) {
        this.videoDetails = videoDetails;
    }

    public RawStreamingData getRawStreamingData() {
        return rawStreamingData;
    }

    public void setRawStreamingData(RawStreamingData rawStreamingData) {
        this.rawStreamingData = rawStreamingData;
    }

    public PlayabilityStatus getPlayabilityStatus() {
        return playabilityStatus;
    }

    public void setPlayabilityStatus(PlayabilityStatus playabilityStatus) {
        this.playabilityStatus = playabilityStatus;
    }

    public List<MessagesItem> getMessages() {
        return messages;
    }

    public void setMessages(List<MessagesItem> messages) {
        this.messages = messages;
    }

    public PlaybackTracking getPlaybackTracking() {
        return playbackTracking;
    }

    public void setPlaybackTracking(PlaybackTracking playbackTracking) {
        this.playbackTracking = playbackTracking;
    }

    public Microformat getMicroformat() {
        return microformat;
    }

    public void setMicroformat(Microformat microformat) {
        this.microformat = microformat;
    }

    public Storyboards getStoryboards() {
        return storyboards;
    }

    public void setStoryboards(Storyboards storyboards) {
        this.storyboards = storyboards;
    }

    @Override
    public String toString() {
        return
                "PlayerResponse{" +
                        "playerConfig = '" + playerConfig + '\'' +
                        ",trackingParams = '" + trackingParams + '\'' +
                        ",attestation = '" + attestation + '\'' +
                        ",videoDetails = '" + videoDetails + '\'' +
                        ",rawStreamingData = '" + rawStreamingData + '\'' +
                        ",playabilityStatus = '" + playabilityStatus + '\'' +
                        ",messages = '" + messages + '\'' +
                        ",playbackTracking = '" + playbackTracking + '\'' +
                        ",microformat = '" + microformat + '\'' +
                        ",storyboards = '" + storyboards + '\'' +
                        "}";
    }
}
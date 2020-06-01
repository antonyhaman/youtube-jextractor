package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class PlaybackTracking implements Serializable {
    private VideostatsWatchtimeUrl videostatsWatchtimeUrl;
    private VideostatsDelayplayUrl videostatsDelayplayUrl;
    private QoeUrl qoeUrl;
    private SetAwesomeUrl setAwesomeUrl;
    private VideostatsPlaybackUrl videostatsPlaybackUrl;
    private PtrackingUrl ptrackingUrl;
    private AtrUrl atrUrl;

    public VideostatsWatchtimeUrl getVideostatsWatchtimeUrl() {
        return videostatsWatchtimeUrl;
    }

    public void setVideostatsWatchtimeUrl(VideostatsWatchtimeUrl videostatsWatchtimeUrl) {
        this.videostatsWatchtimeUrl = videostatsWatchtimeUrl;
    }

    public VideostatsDelayplayUrl getVideostatsDelayplayUrl() {
        return videostatsDelayplayUrl;
    }

    public void setVideostatsDelayplayUrl(VideostatsDelayplayUrl videostatsDelayplayUrl) {
        this.videostatsDelayplayUrl = videostatsDelayplayUrl;
    }

    public QoeUrl getQoeUrl() {
        return qoeUrl;
    }

    public void setQoeUrl(QoeUrl qoeUrl) {
        this.qoeUrl = qoeUrl;
    }

    public SetAwesomeUrl getSetAwesomeUrl() {
        return setAwesomeUrl;
    }

    public void setSetAwesomeUrl(SetAwesomeUrl setAwesomeUrl) {
        this.setAwesomeUrl = setAwesomeUrl;
    }

    public VideostatsPlaybackUrl getVideostatsPlaybackUrl() {
        return videostatsPlaybackUrl;
    }

    public void setVideostatsPlaybackUrl(VideostatsPlaybackUrl videostatsPlaybackUrl) {
        this.videostatsPlaybackUrl = videostatsPlaybackUrl;
    }

    public PtrackingUrl getPtrackingUrl() {
        return ptrackingUrl;
    }

    public void setPtrackingUrl(PtrackingUrl ptrackingUrl) {
        this.ptrackingUrl = ptrackingUrl;
    }

    public AtrUrl getAtrUrl() {
        return atrUrl;
    }

    public void setAtrUrl(AtrUrl atrUrl) {
        this.atrUrl = atrUrl;
    }

    @Override
    public String toString() {
        return
                "PlaybackTracking{" +
                        "videostatsWatchtimeUrl = '" + videostatsWatchtimeUrl + '\'' +
                        ",videostatsDelayplayUrl = '" + videostatsDelayplayUrl + '\'' +
                        ",qoeUrl = '" + qoeUrl + '\'' +
                        ",setAwesomeUrl = '" + setAwesomeUrl + '\'' +
                        ",videostatsPlaybackUrl = '" + videostatsPlaybackUrl + '\'' +
                        ",ptrackingUrl = '" + ptrackingUrl + '\'' +
                        ",atrUrl = '" + atrUrl + '\'' +
                        "}";
    }
}

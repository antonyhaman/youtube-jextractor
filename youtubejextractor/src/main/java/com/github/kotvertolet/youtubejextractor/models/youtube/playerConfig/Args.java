package com.github.kotvertolet.youtubejextractor.models.youtube.playerConfig;

import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.PlayerResponse;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Args implements Serializable {

    @SerializedName("show_content_thumbnail")
    private boolean showContentThumbnail;

    @SerializedName("hl")
    private String hl;

    @SerializedName("length_seconds")
    private String lengthSeconds;

    @SerializedName("gapi_hint_params")
    private String gapiHintParams;

    @SerializedName("title")
    private String title;

    @SerializedName("ssl")
    private String ssl;

    @SerializedName("fmt_list")
    private String fmtList;

    @SerializedName("cver")
    private String cver;

    @SerializedName("enablecsi")
    private String enablecsi;

    @SerializedName("vss_host")
    private String vssHost;

    @SerializedName("csi_page_type")
    private String csiPageType;

    @SerializedName("fexp")
    private String fexp;

    @SerializedName("innertube_context_client_version")
    private String innertubeContextClientVersion;

    @SerializedName("account_playback_token")
    private String accountPlaybackToken;

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("ucid")
    private String ucid;

    @SerializedName("watermark")
    private String watermark;

    @SerializedName("url_encoded_fmt_stream_map")
    private String urlEncodedFmtStreamMap;

    @SerializedName("c")
    private String C;

    @SerializedName("author")
    private String author;

    @SerializedName("player_response")
    private PlayerResponse playerResponse;

    @SerializedName("enabled_engage_types")
    private String enabledEngageTypes;

    @SerializedName("innertube_api_key")
    private String innertubeApiKey;

    @SerializedName("cr")
    private String cr;

    @SerializedName("host_language")
    private String hostLanguage;

    @SerializedName("innertube_api_version")
    private String innertubeApiVersion;

    @SerializedName("loaderUrl")
    private String loaderUrl;

    @SerializedName("adaptive_fmts")
    private String adaptiveFmts;

    @SerializedName("enablejsapi")
    private String enablejsapi;

    @SerializedName("video_id")
    private String videoId;

    @SerializedName("fflags")
    private String fflags;

    public boolean isShowContentThumbnail() {
        return showContentThumbnail;
    }

    public void setShowContentThumbnail(boolean showContentThumbnail) {
        this.showContentThumbnail = showContentThumbnail;
    }

    public String getHl() {
        return hl;
    }

    public void setHl(String hl) {
        this.hl = hl;
    }

    public String getLengthSeconds() {
        return lengthSeconds;
    }

    public void setLengthSeconds(String lengthSeconds) {
        this.lengthSeconds = lengthSeconds;
    }

    public String getGapiHintParams() {
        return gapiHintParams;
    }

    public void setGapiHintParams(String gapiHintParams) {
        this.gapiHintParams = gapiHintParams;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSsl() {
        return ssl;
    }

    public void setSsl(String ssl) {
        this.ssl = ssl;
    }

    public String getFmtList() {
        return fmtList;
    }

    public void setFmtList(String fmtList) {
        this.fmtList = fmtList;
    }

    public String getCver() {
        return cver;
    }

    public void setCver(String cver) {
        this.cver = cver;
    }

    public String getEnablecsi() {
        return enablecsi;
    }

    public void setEnablecsi(String enablecsi) {
        this.enablecsi = enablecsi;
    }

    public String getVssHost() {
        return vssHost;
    }

    public void setVssHost(String vssHost) {
        this.vssHost = vssHost;
    }

    public String getCsiPageType() {
        return csiPageType;
    }

    public void setCsiPageType(String csiPageType) {
        this.csiPageType = csiPageType;
    }

    public String getFexp() {
        return fexp;
    }

    public void setFexp(String fexp) {
        this.fexp = fexp;
    }

    public String getInnertubeContextClientVersion() {
        return innertubeContextClientVersion;
    }

    public void setInnertubeContextClientVersion(String innertubeContextClientVersion) {
        this.innertubeContextClientVersion = innertubeContextClientVersion;
    }

    public String getAccountPlaybackToken() {
        return accountPlaybackToken;
    }

    public void setAccountPlaybackToken(String accountPlaybackToken) {
        this.accountPlaybackToken = accountPlaybackToken;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUcid() {
        return ucid;
    }

    public void setUcid(String ucid) {
        this.ucid = ucid;
    }

    public String getWatermark() {
        return watermark;
    }

    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    public String getUrlEncodedFmtStreamMap() {
        return urlEncodedFmtStreamMap;
    }

    public void setUrlEncodedFmtStreamMap(String urlEncodedFmtStreamMap) {
        this.urlEncodedFmtStreamMap = urlEncodedFmtStreamMap;
    }

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public PlayerResponse getPlayerResponse() {
        return playerResponse;
    }

    public void setPlayerResponse(PlayerResponse playerResponse) {
        this.playerResponse = playerResponse;
    }

    public String getEnabledEngageTypes() {
        return enabledEngageTypes;
    }

    public void setEnabledEngageTypes(String enabledEngageTypes) {
        this.enabledEngageTypes = enabledEngageTypes;
    }

    public String getInnertubeApiKey() {
        return innertubeApiKey;
    }

    public void setInnertubeApiKey(String innertubeApiKey) {
        this.innertubeApiKey = innertubeApiKey;
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }

    public String getHostLanguage() {
        return hostLanguage;
    }

    public void setHostLanguage(String hostLanguage) {
        this.hostLanguage = hostLanguage;
    }

    public String getInnertubeApiVersion() {
        return innertubeApiVersion;
    }

    public void setInnertubeApiVersion(String innertubeApiVersion) {
        this.innertubeApiVersion = innertubeApiVersion;
    }

    public String getLoaderUrl() {
        return loaderUrl;
    }

    public void setLoaderUrl(String loaderUrl) {
        this.loaderUrl = loaderUrl;
    }

    public String getAdaptiveFmts() {
        return adaptiveFmts;
    }

    public void setAdaptiveFmts(String adaptiveFmts) {
        this.adaptiveFmts = adaptiveFmts;
    }

    public String getEnablejsapi() {
        return enablejsapi;
    }

    public void setEnablejsapi(String enablejsapi) {
        this.enablejsapi = enablejsapi;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getFflags() {
        return fflags;
    }

    public void setFflags(String fflags) {
        this.fflags = fflags;
    }

    @Override
    public String toString() {
        return
                "Args{" +
                        "show_content_thumbnail = '" + showContentThumbnail + '\'' +
                        ",hl = '" + hl + '\'' +
                        ",length_seconds = '" + lengthSeconds + '\'' +
                        ",gapi_hint_params = '" + gapiHintParams + '\'' +
                        ",title = '" + title + '\'' +
                        ",ssl = '" + ssl + '\'' +
                        ",fmt_list = '" + fmtList + '\'' +
                        ",cver = '" + cver + '\'' +
                        ",enablecsi = '" + enablecsi + '\'' +
                        ",vss_host = '" + vssHost + '\'' +
                        ",csi_page_type = '" + csiPageType + '\'' +
                        ",fexp = '" + fexp + '\'' +
                        ",innertube_context_client_version = '" + innertubeContextClientVersion + '\'' +
                        ",account_playback_token = '" + accountPlaybackToken + '\'' +
                        ",timestamp = '" + timestamp + '\'' +
                        ",ucid = '" + ucid + '\'' +
                        ",watermark = '" + watermark + '\'' +
                        ",url_encoded_fmt_stream_map = '" + urlEncodedFmtStreamMap + '\'' +
                        ",c = '" + C + '\'' +
                        ",author = '" + author + '\'' +
                        ",player_response = '" + playerResponse + '\'' +
                        ",enabled_engage_types = '" + enabledEngageTypes + '\'' +
                        ",innertube_api_key = '" + innertubeApiKey + '\'' +
                        ",cr = '" + cr + '\'' +
                        ",host_language = '" + hostLanguage + '\'' +
                        ",innertube_api_version = '" + innertubeApiVersion + '\'' +
                        ",loaderUrl = '" + loaderUrl + '\'' +
                        ",adaptive_fmts = '" + adaptiveFmts + '\'' +
                        ",enablejsapi = '" + enablejsapi + '\'' +
                        ",video_id = '" + videoId + '\'' +
                        ",fflags = '" + fflags + '\'' +
                        "}";
    }
}
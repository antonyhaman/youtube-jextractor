package com.github.kotvertolet.youtubejextractor.pojo.youtube.playerConfig;

import com.google.gson.annotations.SerializedName;

public class VideoPlayerConfig {

    @SerializedName("args")
    private Args args;

    @SerializedName("sts")
    private int sts;

    @SerializedName("assets")
    private Assets assets;

    @SerializedName("attrs")
    private Attrs attrs;

    public void setArgs(Args args) {
        this.args = args;
    }

    public Args getArgs() {
        return args;
    }

    public void setSts(int sts) {
        this.sts = sts;
    }

    public int getSts() {
        return sts;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public Assets getAssets() {
        return assets;
    }

    public void setAttrs(Attrs attrs) {
        this.attrs = attrs;
    }

    public Attrs getAttrs() {
        return attrs;
    }

    @Override
    public String toString() {
        return
                "VideoPlayerConfig{" +
                        "args = '" + args + '\'' +
                        ",sts = '" + sts + '\'' +
                        ",assets = '" + assets + '\'' +
                        ",attrs = '" + attrs + '\'' +
                        "}";
    }
}
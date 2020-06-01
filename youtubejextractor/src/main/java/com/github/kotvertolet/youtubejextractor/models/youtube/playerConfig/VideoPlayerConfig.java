package com.github.kotvertolet.youtubejextractor.models.youtube.playerConfig;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VideoPlayerConfig implements Serializable {

    @SerializedName("args")
    private Args args;

    @SerializedName("sts")
    private int sts;

    @SerializedName("assets")
    private Assets assets;

    @SerializedName("attrs")
    private Attrs attrs;

    public Args getArgs() {
        return args;
    }

    public void setArgs(Args args) {
        this.args = args;
    }

    public int getSts() {
        return sts;
    }

    public void setSts(int sts) {
        this.sts = sts;
    }

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public Attrs getAttrs() {
        return attrs;
    }

    public void setAttrs(Attrs attrs) {
        this.attrs = attrs;
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
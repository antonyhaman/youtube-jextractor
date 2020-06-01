package com.github.kotvertolet.youtubejextractor.models.youtube.playerConfig;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Assets implements Serializable {

    @SerializedName("css")
    private String css;

    @SerializedName("js")
    private String js;

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    @Override
    public String toString() {
        return
                "Assets{" +
                        "css = '" + css + '\'' +
                        ",js = '" + js + '\'' +
                        "}";
    }
}
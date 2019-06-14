package com.github.kotvertolet.youtubejextractor.pojo.youtube.playerConfig;

import com.google.gson.annotations.SerializedName;

public class Assets {

    @SerializedName("css")
    private String css;

    @SerializedName("js")
    private String js;

    public void setCss(String css) {
        this.css = css;
    }

    public String getCss() {
        return css;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public String getJs() {
        return js;
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
package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

import static com.github.kotvertolet.youtubejextractor.utils.StringUtils.urlDecode;

public class Cipher implements Serializable {

    private String s;
    private String sp;
    private String url;

    public Cipher(String s, String sp, String url) {
        this.s = s;
        this.sp = sp;
        this.url = url;
    }

    public String getS() {
        return urlDecode(s);
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

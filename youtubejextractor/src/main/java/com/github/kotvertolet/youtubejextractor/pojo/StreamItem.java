package com.github.kotvertolet.youtubejextractor.pojo;

import com.github.kotvertolet.youtubejextractor.pojo.enums.Extension;

import java.util.Map;

import static com.github.kotvertolet.youtubejextractor.utils.StringUtils.extractExtension;

public abstract class StreamItem {

    protected Extension extension;
    protected String codec;
    protected int bitrate;
    protected String signature;
    protected String sp;
    protected int iTag;
    protected String url;
    protected boolean isStreamEncrypted;

    public StreamItem(Map<String, String> map) {
        String[] tempArr = map.get("type").split(";");
        String[] typeArr = tempArr[0].split("/");
        extension = extractExtension(typeArr[1]);
        codec = tempArr[1].split("=")[1].replaceAll("\"", "");
        signature = map.get("s");
        sp = map.get("sp");
        isStreamEncrypted = signature != null;
        String rawItag = map.get("itag") == null ? "0" : map.get("itag");
        iTag = Integer.valueOf(rawItag);
        url = map.get("url");
        String rawBitrate = map.get("bitrate") == null ? "0" : map.get("bitrate");
        bitrate = Integer.valueOf(rawBitrate);
    }

    public String getUrl() {
        if (isStreamEncrypted) {
            isStreamEncrypted = false;
            url = String.format("%s&%s=%s", url, sp, signature);
            if (!url.contains("ratebypass")) {
                url = url + "&ratebypass=yes";
            }
            isStreamEncrypted = false;
        }
        return url;
    }
}

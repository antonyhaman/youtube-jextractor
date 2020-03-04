package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class MediaCommonConfig {

    private DynamicReadaheadConfig dynamicReadaheadConfig;

    public DynamicReadaheadConfig getDynamicReadaheadConfig() {
        return dynamicReadaheadConfig;
    }

    public void setDynamicReadaheadConfig(DynamicReadaheadConfig dynamicReadaheadConfig) {
        this.dynamicReadaheadConfig = dynamicReadaheadConfig;
    }

    @Override
    public String toString() {
        return
                "MediaCommonConfig{" +
                        "dynamicReadaheadConfig = '" + dynamicReadaheadConfig + '\'' +
                        "}";
    }
}

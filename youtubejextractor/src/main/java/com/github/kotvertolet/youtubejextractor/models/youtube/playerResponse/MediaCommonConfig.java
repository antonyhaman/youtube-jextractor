package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class MediaCommonConfig implements Serializable {

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

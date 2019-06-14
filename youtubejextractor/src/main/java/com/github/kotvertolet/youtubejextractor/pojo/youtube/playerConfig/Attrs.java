package com.github.kotvertolet.youtubejextractor.pojo.youtube.playerConfig;

import com.google.gson.annotations.SerializedName;

public class Attrs {

    @SerializedName("id")
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "Attrs{" +
                        "id = '" + id + '\'' +
                        "}";
    }
}
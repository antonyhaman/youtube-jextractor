package com.github.kotvertolet.youtubejextractor.models.youtube.playerConfig;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Attrs implements Serializable {

    @SerializedName("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "Attrs{" +
                        "id = '" + id + '\'' +
                        "}";
    }
}
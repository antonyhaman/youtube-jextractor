package com.github.kotvertolet.youtubejextractor.models.subtitles;

class Link {

    private String type;
    private String rel;
    private String id;

    public Link(String type, String rel, String id) {
        this.type = type;
        this.rel = rel;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

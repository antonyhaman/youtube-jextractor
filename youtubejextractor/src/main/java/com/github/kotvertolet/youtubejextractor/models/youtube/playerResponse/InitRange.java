package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class InitRange {

    private String start;
    private String end;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return
                "InitRange{" +
                        "start = '" + start + '\'' +
                        ",end = '" + end + '\'' +
                        "}";
    }
}

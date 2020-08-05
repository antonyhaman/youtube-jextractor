package com.github.kotvertolet.youtubejextractor.models.subtitles;

public class Text {

    private String start;
    private String dur;
    private String text;

    public Text(String start, String dur, String text) {
        this.start = start;
        this.dur = dur;
        this.text = text;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDur() {
        return dur;
    }

    public void setDur(String dur) {
        this.dur = dur;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

package com.github.kotvertolet.youtubejextractor.models.subtitles;

public class Subtitle {

    private String start;
    private String duration;
    private String text;

    public Subtitle(String start, String duration, String text) {
        this.start = start;
        this.duration = duration;
        this.text = text;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subtitle subtitle = (Subtitle) o;

        if (start != null ? !start.equals(subtitle.start) : subtitle.start != null) return false;
        if (duration != null ? !duration.equals(subtitle.duration) : subtitle.duration != null)
            return false;
        return text != null ? text.equals(subtitle.text) : subtitle.text == null;
    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subtitle{" +
                "start='" + start + '\'' +
                ", duration='" + duration + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

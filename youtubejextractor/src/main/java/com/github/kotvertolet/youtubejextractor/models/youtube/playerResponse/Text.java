package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.util.List;

public class Text {
    private List<RunsItem> runs;

    public List<RunsItem> getRuns() {
        return runs;
    }

    public void setRuns(List<RunsItem> runs) {
        this.runs = runs;
    }

    @Override
    public String toString() {
        return
                "Text{" +
                        "runs = '" + runs + '\'' +
                        "}";
    }
}
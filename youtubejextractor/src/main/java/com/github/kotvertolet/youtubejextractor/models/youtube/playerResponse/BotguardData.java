package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class BotguardData {

    private String interpreterUrl;
    private String program;

    public String getInterpreterUrl() {
        return interpreterUrl;
    }

    public void setInterpreterUrl(String interpreterUrl) {
        this.interpreterUrl = interpreterUrl;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return
                "BotguardData{" +
                        "interpreterUrl = '" + interpreterUrl + '\'' +
                        ",program = '" + program + '\'' +
                        "}";
    }
}

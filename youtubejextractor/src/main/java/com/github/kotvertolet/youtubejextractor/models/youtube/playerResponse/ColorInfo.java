package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class ColorInfo implements Serializable {

    private String primaries;
    private String matrixCoefficients;
    private String transferCharacteristics;

    public String getPrimaries() {
        return primaries;
    }

    public void setPrimaries(String primaries) {
        this.primaries = primaries;
    }

    public String getMatrixCoefficients() {
        return matrixCoefficients;
    }

    public void setMatrixCoefficients(String matrixCoefficients) {
        this.matrixCoefficients = matrixCoefficients;
    }

    public String getTransferCharacteristics() {
        return transferCharacteristics;
    }

    public void setTransferCharacteristics(String transferCharacteristics) {
        this.transferCharacteristics = transferCharacteristics;
    }

    @Override
    public String toString() {
        return
                "ColorInfo{" +
                        "primaries = '" + primaries + '\'' +
                        ",matrixCoefficients = '" + matrixCoefficients + '\'' +
                        ",transferCharacteristics = '" + transferCharacteristics + '\'' +
                        "}";
    }
}

package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class ButtonRenderer implements Serializable {

    private String trackingParams;
    private String size;
    private String style;
    private Text text;
    private NavigationEndpoint navigationEndpoint;
    private ServiceEndpoint serviceEndpoint;

    public String getTrackingParams() {
        return trackingParams;
    }

    public void setTrackingParams(String trackingParams) {
        this.trackingParams = trackingParams;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public NavigationEndpoint getNavigationEndpoint() {
        return navigationEndpoint;
    }

    public void setNavigationEndpoint(NavigationEndpoint navigationEndpoint) {
        this.navigationEndpoint = navigationEndpoint;
    }

    public ServiceEndpoint getServiceEndpoint() {
        return serviceEndpoint;
    }

    public void setServiceEndpoint(ServiceEndpoint serviceEndpoint) {
        this.serviceEndpoint = serviceEndpoint;
    }

    @Override
    public String toString() {
        return
                "ButtonRenderer{" +
                        "trackingParams = '" + trackingParams + '\'' +
                        ",size = '" + size + '\'' +
                        ",style = '" + style + '\'' +
                        ",text = '" + text + '\'' +
                        ",navigationEndpoint = '" + navigationEndpoint + '\'' +
                        ",serviceEndpoint = '" + serviceEndpoint + '\'' +
                        "}";
    }
}

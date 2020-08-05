package com.github.kotvertolet.youtubejextractor.models.subtitles;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Transcript {

    private ArrayList<Link> link;
    private Style style;

}

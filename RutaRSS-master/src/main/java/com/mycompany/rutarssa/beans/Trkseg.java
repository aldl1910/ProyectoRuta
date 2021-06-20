package com.mycompany.rutarssa.beans;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;

public class Trkseg {
    
    private ArrayList<Trkpt> trkpt = new ArrayList<Trkpt>();

    public ArrayList<Trkpt> getTrkpt() {
        return trkpt;

    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    public void setTrkpt(ArrayList<Trkpt> trkpt) {
        this.trkpt = trkpt;
    }
}


package com.mycompany.rutarssa.beans;

import javax.xml.bind.annotation.XmlElement;

public class Trk {
    
    private Trkseg trkseg;
    private String name;
    
    public Trkseg getTrkseg(){
        return trkseg;
    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    public void setTrkseg(Trkseg trkseg){
        this.trkseg = trkseg;
    }
    
    public String getName(){
        return name;
    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    public void setName(String name){
        this.name = name;
    }
}

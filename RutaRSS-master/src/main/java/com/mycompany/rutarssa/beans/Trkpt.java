package com.mycompany.rutarssa.beans;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


public class Trkpt {
    
    private String lat;
    private double lon;
    private double ele;
    private LocalDate time;
    
    public Trkpt(){

}
    public Trkpt(String lat){
        this.lat = lat;
        this.lon = lon;
        this.ele = ele;
        this.time = time;
    }
    
    public String getLat(){
        return lat;
    }
    
    @XmlAttribute
    public void setLat(String lat){
        this.lat = lat;
    }
    
    public double getLon(){
        return lon;
    }
    
    @XmlAttribute
    public void setLon(double lon){
        this.lon = lon;
    }
    
    public double getEle(){
        return ele;
    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    public void setEle(double ele){
        this.ele = ele;
    }
    
    public LocalDate getTime(){
        return time;
    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    @XmlJavaTypeAdapter(value = AdaptadorFecha.class)
    public void setTime(LocalDate time){
        this.time = time;
    }
}

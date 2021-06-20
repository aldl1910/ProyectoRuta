package com.mycompany.rutarssa.beans;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class ItemsTRK {
    
    private String name;
    private double lat;
    private double lon;
    private double ele;
    private LocalDate time;
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public double getLat(){
        return lat;
    }
    
    public void setLat(double lat){
        this.lat = lat;
    }
    
    public double getLon(){
        return lon;
    }
    
    public void setLon(double lon){
        this.lon = lon;
    }
    
    public double getEle(){
        return ele;
    }
    
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

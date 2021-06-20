package com.mycompany.rutarssa.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Metadata {
    
    private String name;
    private String author;
    private String link;
    private String text;
    private String time;
    
    public String getName(){
        return name;
    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    public void setName(String name){
        this.name = name;
    }
    
    public String getAuthor(){
        return author;
    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    public void setAuthor(String author){
        this.author = author;
    }
    
    public String getLink(){
        return link;
    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    public void setLink(String link){
        this.link = link;
    }
    
    public String getText(){
        return text;
    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    public void setText(String text){
        this.text = text;
    }
    
    public String getTime(){
        return time;
    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
//    @XmlJavaTypeAdapter(value = AdaptadorFecha.class)
    public void setTime(String time){
        this.time = time;
    }
}

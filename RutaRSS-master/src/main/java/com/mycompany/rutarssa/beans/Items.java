package com.mycompany.rutarssa.beans;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Items {
    
    private String name;
    private String link;
    private LocalDate time;
    
    //Método que nos devuelve el nombre
    public String getName(){
        return name;
    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    //Método con el que podemos cambiar el nombre
    public void setName(String name){
        this.name = name;
    }
    
    //Método que nos devuelve el link
    public String getLink(){
        return link;
    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    //Método con el que podemos cambiar el link
    public void setLink(String link){
        this.link = link;
    }
    
    //Método que nos devuelve la fecha y hora
    public LocalDate getTime(){
        return time;
    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    @XmlJavaTypeAdapter(value = AdaptadorFecha.class)
    //Método con el que podemos cambiar la fecha y la hora
    public void setTime(LocalDate time){
        this.time = time;
    }
}

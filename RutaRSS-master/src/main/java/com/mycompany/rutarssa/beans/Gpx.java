package com.mycompany.rutarssa.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace="http://www.topografix.com/GPX/1/1")
public class Gpx {
    
    private Metadata metadata;
    private Trk trk;
    
    public Metadata getMetadata(){
        return metadata;
    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    
    public Trk getTrk(){
        return trk;
    }
    
    @XmlElement(namespace="http://www.topografix.com/GPX/1/1")
    public void setTrk(Trk trk){
        this.trk = trk;
    }
}

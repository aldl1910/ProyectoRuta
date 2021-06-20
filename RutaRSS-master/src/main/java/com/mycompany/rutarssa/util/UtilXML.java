package com.mycompany.rutarssa.util;

import com.mycompany.rutarssa.beans.Gpx;
import java.io.File;
import java.net.MalformedURLException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


//Esta clase es la que contiene el método que nos procesa los archivos GPX
public class UtilXML {
    public static Gpx procesarGPX(File file) throws JAXBException, MalformedURLException{
        JAXBContext contexto = JAXBContext.newInstance(Gpx.class);
        Unmarshaller unmarshaller = contexto.createUnmarshaller();
        Gpx gpx = (Gpx)unmarshaller.unmarshal(file);
        return gpx;
    }
}

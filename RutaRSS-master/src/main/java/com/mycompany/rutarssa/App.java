package com.mycompany.rutarssa;

import com.mycompany.rutarssa.beans.Gpx;
import com.mycompany.rutarssa.beans.Trkpt;
import com.mycompany.rutarssa.util.UtilXML;
import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class App extends Application {
    
    private final double DEFAULT_LAT = 36.67969;
    private final double DEFAULT_LON = -5.44484;
    private final int DEFAULT_ZOOM = 15;
    private WebView webView = new WebView();
    private WebEngine webEngine = webView.getEngine();
    TextArea textArea = new TextArea();
    private static VBox vboxItems = new VBox();
    private static Label labelTituloGPX = new Label();
    private static Label labelTiempoGPX = new Label();
    VBox paneCenter = new VBox(textArea);
    Gpx gpx;
    
    @Override
    public void start(Stage stage) {
        BorderPane rootPane = new BorderPane();
        var scene = new Scene(rootPane, 640, 480);
        stage.setScene(scene);
        stage.show();
        rootPane.setTop(paneTop(stage, textArea));
        rootPane.setCenter(paneCenter);
        textArea.setEditable(false);
        
        
        URL urlWebMap = this.getClass().getResource("/web/mapa.html");
        webEngine.load(urlWebMap.toString());
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldState, newState)->{
            if(newState == Worker.State.SUCCEEDED ) {
                webEngine.executeScript("initMap("+DEFAULT_LAT+","+DEFAULT_LON+","+DEFAULT_ZOOM+")");
            }
        });
        rootPane.setRight(webView);
        
        
    }
        
    public VBox paneTop(Stage stage, TextArea textArea){
        Button botonProcesarGpx = new Button("Procesa GPX");
        Button buttonAbrirFichero = new Button("Abrir archivo");
        Button buttonBrowse = new Button("Dibujar línea");
        HBox hbox  = new HBox(botonProcesarGpx, buttonAbrirFichero, buttonBrowse);
        hbox.setSpacing(10);
        VBox vbox = new VBox(hbox, labelTituloGPX, labelTiempoGPX);
        vbox.setSpacing(10);
        buttonAbrirFichero.setOnAction((t) ->{
            procesarXmlFileGPX(stage, textArea);
        });
        botonProcesarGpx.setOnAction((t) -> {
            //leerGPX();
        });
        buttonBrowse.setOnAction((t) -> {
            dibujarLinea();
        });
        return vbox;
    }
    public void procesarXmlFileGPX(Stage stage, TextArea textArea){
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Abrir Ruta GPX");
            File archivoSeleccionado = fileChooser.showOpenDialog(stage);
            gpx = UtilXML.procesarGPX(archivoSeleccionado);
            System.out.println(gpx.getMetadata().getName());
            String strGpxNombreRuta = "";
            strGpxNombreRuta += gpx.getMetadata().getName();
            String strGpxTiempoRuta = "";
            strGpxTiempoRuta += gpx.getMetadata().getTime();
            
            //Mostrar los datos elegidos en el textArea con un salto de línea
            textArea.setText(strGpxNombreRuta + "\n" + strGpxTiempoRuta);
            
        } catch (Exception ex) {
            System.out.println(ex.toString());
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Error al procesar el documento");
            alert.setContentText(ex.toString());
            alert.showAndWait();
        }
    }
    public void dibujarLinea() {
        System.out.println(gpx.getTrk().getName());
        
        String r = "[";
        for(Trkpt trkpt : gpx.getTrk().getTrkseg().getTrkpt()) {           
                r +="[" + trkpt.getLat()+", " + trkpt.getLon()+ "]" + ", ";
        }
            r += "]";
        webEngine.executeScript("clearTrack()");
        webEngine.executeScript("drawTrack("+r+")");
    }
    
    
//    public static HBox paneCenter(){
//        ScrollPane scroll = new ScrollPane();
//        scroll.setFitToWidth(true);
//        scroll.setMinWidth(320);
//        scroll.setPrefWidth(320);
//        scroll.setContent(vboxItems);
//        HBox hbox = new HBox(webView);
//        return hbox;
//    }
//    
//    public static void leerGPX(){
//        try{
//            
//                });
//            }
//        } catch (JAXBException ex){
//            App.errorDeCarga("El formato del GPX es incorrecto", ex);
//        } catch (MalformedURLException ex) {
//            App.errorDeCarga("La dirección del RSS es incorrecta", ex);
//        } catch (Exception ex) {
//            App.errorDeCarga("Se ha producido un error desconocido", ex);
//        }
//    
//    public static void errorDeCarga(String mensaje, Exception ex){
//        System.out.println(ex.toString());
//        Alert alert = new Alert(AlertType.ERROR);
//        alert.setHeaderText(mensaje);
//        alert.setContentText(ex.toString());
//        alert.showAndWait();
//    }
//    
//    public static void main(String[] args) {
//        launch();
//    }

}
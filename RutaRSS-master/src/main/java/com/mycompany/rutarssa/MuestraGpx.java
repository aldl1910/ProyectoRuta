//package com.mycompany.rutarssa;
//
//import com.mycompany.rutarssa.beans.Gpx;
//import com.mycompany.rutarssa.beans.Trkpt;
//import com.mycompany.rutarssa.util.UtilXML;
//import java.io.File;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.control.TextArea;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.web.WebView;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//
//
//public class MuestraGpx {
//    
//    private static VBox vboxItems = new VBox();
//    private static Label labelTituloGPX = new Label();
//    private static WebView webView = new WebView();
//    TextArea textArea = new TextArea();
//    VBox paneCenter = new VBox(textArea);
//    
//        
//    public static VBox paneTop(Stage stage, TextArea textArea){
//        Button botonProcesarGpx = new Button("Procesa GPX");
//        Button buttonAbrirFichero = new Button("Abrir archivo");
//        HBox hbox  = new HBox(botonProcesarGpx, buttonAbrirFichero);
//        hbox.setSpacing(10);
//        VBox vbox = new VBox(hbox, labelTituloGPX);
//        vbox.setSpacing(10);
//        buttonAbrirFichero.setOnAction((t) ->{
//            procesarXmlFileGPX(stage, textArea);
//        });
//        botonProcesarGpx.setOnAction((t) -> {
//            //leerGPX();
//        });
//        return vbox;
//    }
//    public static void procesarXmlFileGPX(Stage stage, TextArea textArea){
//        try {
//            FileChooser fileChooser = new FileChooser();
//            fileChooser.setTitle("Abrir XML de Marchas");
//            File archivoSeleccionado = fileChooser.showOpenDialog(stage);
//            Gpx gpx = UtilXML.procesarGPX(archivoSeleccionado);
//            System.out.println(gpx.getMetadata().getName());
//            System.out.println(gpx.getTrk().getTrkseg().getTrkpt().getEle());
//            String strMarchas = "";
//            String strGpxLabelCoordenadas = "";
//            strGpxLabelCoordenadas += gpx.getMetadata().getName();
//            //strGpxLabelCoordenadas += "Lat: " + trkpt.getLat() + "\n";
////            for(Trkpt trkpt : gpx.getTrk().getTrkseg().getTrkpt()){
////                strMarchas += "Lat: " + trkpt.getLat() + "\n";
////            }
//            textArea.setText(strGpxLabelCoordenadas);
//        } catch (Exception ex) {
//            System.out.println(ex.toString());
//            Alert alert = new Alert(AlertType.ERROR);
//            alert.setHeaderText("Error al procesar el documento");
//            alert.setContentText(ex.toString());
//            alert.showAndWait();
//        }
//    }
//    
//    
//    
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
////    public static void leerGPX(){
////        try{
////            
////                });
////            }
////        } catch (JAXBException ex){
////            App.errorDeCarga("El formato del GPX es incorrecto", ex);
////        } catch (MalformedURLException ex) {
////            App.errorDeCarga("La dirección del RSS es incorrecta", ex);
////        } catch (Exception ex) {
////            App.errorDeCarga("Se ha producido un error desconocido", ex);
////        }
////    }
//    
//    
//}

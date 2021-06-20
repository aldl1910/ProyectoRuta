module com.mycompany.rutarssa {
    requires javafx.controls;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    requires javafx.web;
    opens com.mycompany.rutarssa.beans to java.xml.bind;
    opens com.mycompany.rutarssa.util to java.xml.bind;
    opens com.mycompany.rutarssa to java.xml.bind;
    exports com.mycompany.rutarssa;
}

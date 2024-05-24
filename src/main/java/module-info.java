module com.example.letrasdemusicas {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.gluonhq.charm.glisten;
    requires org.apache.httpcomponents.client5.httpclient5;
    requires org.apache.httpcomponents.core5.httpcore5;
    requires org.json;


    opens com.example.letrasdemusicas.Model to javafx.fxml;
    exports com.example.letrasdemusicas;
    opens com.example.letrasdemusicas.Controller to javafx.fxml;
}
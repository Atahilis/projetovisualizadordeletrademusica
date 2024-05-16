module com.example.letrasdemusicas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.letrasdemusicas to javafx.fxml;
    exports com.example.letrasdemusicas;
}
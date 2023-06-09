module com.example.rentathing {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rentathing to javafx.fxml;
    exports com.example.rentathing;
}
module com.example.rentathing {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rentathing to javafx.fxml;
    exports com.example.rentathing;
    exports com.example.rentathing.product;
    opens com.example.rentathing.product to javafx.fxml;
    exports com.example.rentathing.controllers;
    opens com.example.rentathing.controllers to javafx.fxml;
}
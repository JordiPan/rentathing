package com.example.rentathing;

import com.example.rentathing.product.Boormachine;
import com.example.rentathing.product.PersonenAuto;
import com.example.rentathing.product.Product;
import com.example.rentathing.product.Vrachtauto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        Database.voegObserversToe();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("inlog-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
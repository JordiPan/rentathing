package com.example.rentathing.controllers;

import com.example.rentathing.Database;
import com.example.rentathing.Main;
import com.example.rentathing.product.PersonenAuto;
import com.example.rentathing.product.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OverzichtController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private VBox producten;
    @FXML
    protected void getProducten() {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (Product product : Database.producten) {
            Label label = new Label(product.getNaam()+" - verhuurd: "+ product.isVerhuurd());
            label.setStyle("-fx-border-color: black; -fx-padding: 10;");
            label.setOnMouseClicked((MouseEvent e) ->{
                Parent root = null;
                try {
                    root = new FXMLLoader(Main.class.getResource("overzicht-view.fxml")).load();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(label.getScene().getWindow());
                stage.setScene(scene);
                Stage huidigeStage = (Stage)((Node) e.getSource()).getScene().getWindow();

                stage.setTitle(huidigeStage.getTitle());
                stage.show();
            });
//            list.getItems().add(product.getNaam() + " " + product.isVerhuurd());
            producten.getChildren().add(label);
        }
    }
}
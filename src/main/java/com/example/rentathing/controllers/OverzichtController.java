package com.example.rentathing.controllers;

import com.example.rentathing.Database;
import com.example.rentathing.Main;
import com.example.rentathing.product.PersonenAuto;
import com.example.rentathing.product.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OverzichtController implements Initializable {
    @FXML
    private VBox producten;
    @FXML
    protected void refresh() {
        producten.getChildren().clear();
        printProducten();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        printProducten();
    }
    public void printProducten() {
        for (Product product : Database.producten) {
            Label label = new Label(product.getNaam()+" - verhuurd: "+ product.isVerhuurd());
            label.setStyle("-fx-border-color: black; -fx-padding: 10;");

            label.setOnMouseClicked((MouseEvent e) ->{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/rentathing/detail-view.fxml"));
                DetailController detailController = new DetailController();
                detailController.setProduct(product);
                loader.setController(detailController);
                Parent root = null;

                try {
                    root = (Parent) loader.load();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(label.getScene().getWindow());
                Stage huidigeStage = (Stage)((Node) e.getSource()).getScene().getWindow();
                stage.setTitle(huidigeStage.getTitle());

                stage.setOnHidden(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent windowEvent) {
                        refresh();
                    }
                });

                stage.show();
            });
//            list.getItems().add(product.getNaam() + " " + product.isVerhuurd());
            producten.getChildren().add(label);
        }
    }
}
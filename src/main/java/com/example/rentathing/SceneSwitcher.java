package com.example.rentathing;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SceneSwitcher {
    public static Stage veranderStage(Parent root, String naam) {
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(naam);
        return stage;
    }

//    public static void sceneWisselenModality(Window parent, String fxml, String naam) throws IOException {
//        Parent root = new FXMLLoader(Main.class.getResource(fxml)).load();
//        Scene scene = new Scene(root);
//        Stage stage = new Stage();
//        stage.initModality(Modality.WINDOW_MODAL);
//        stage.initOwner(parent);
//        stage.setScene(scene);
//        stage.setTitle(naam);
//        stage.show();
//    }
    public static Stage maakStageMetModality(Window parent, Parent root, String naam){
        Stage stage = veranderStage(root,naam);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(parent);
        return stage;
    }

}

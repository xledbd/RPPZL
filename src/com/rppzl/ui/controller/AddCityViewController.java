package com.rppzl.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AddCityViewController {


    public void showAddCountryView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("com/rppzl/ui/fxml/AddCountryView.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        Stage popupStage = new Stage();

        popupStage.initOwner(((Node)event.getSource()).getScene().getWindow());
        popupStage.initModality(Modality.WINDOW_MODAL);
        popupStage.setScene(scene);
        popupStage.showAndWait();

    }
}

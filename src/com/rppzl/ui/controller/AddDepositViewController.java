package com.rppzl.ui.controller;

import com.rppzl.entity.CreditProduct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddDepositViewController {

    @FXML private ChoiceBox<CreditProduct> typeOfDepositChoiceBox;
    @FXML private TextField sumOfDepositTextField;

    public void changeSceneToAccountInfo(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/rppzl/ui/fxml/AccountView.fxml"));
        Parent signupViewParent = loader.load();

        Scene signupViewScene = new Scene(signupViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Счет клиента");
        window.setScene(signupViewScene);
        window.show();
    }


    public void saveDepositButtonPressed(ActionEvent event) throws IOException
    {

    }


}

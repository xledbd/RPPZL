package com.rppzl.ui.controller;

import com.rppzl.dao.CreditAccountDAO;
import com.rppzl.dao.CreditProductDAO;
import com.rppzl.dao.DepositAccountDAO;
import com.rppzl.dao.DepositProductDAO;
import com.rppzl.entity.CreditAccount;
import com.rppzl.entity.CreditProduct;
import com.rppzl.entity.DepositAccount;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddCreditViewController implements Initializable {

    @FXML private ChoiceBox<CreditProduct> typeOfCreditChoiceBox;
    @FXML private TextField sumOfCreditTextField;

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


    public void saveCreditButtonPressed(ActionEvent event) throws IOException
    {
        CreditAccount account = new CreditAccount();
        account.setPersonalAccount(AccountViewController.account);
        String number = AccountViewController.account.getNumber().substring(0, 11);
        int n = new CreditAccountDAO().getList().size() + 1;
        if (n < 10) number += "0";
        number += n;
        account.setNumber(number);
        account.setProduct(typeOfCreditChoiceBox.getSelectionModel().getSelectedItem());
        account.setSum(Double.parseDouble(sumOfCreditTextField.getText()));
        account.setStartDate(LocalDate.now());
        new CreditAccountDAO().save(account);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeOfCreditChoiceBox.setItems(FXCollections.observableArrayList(new CreditProductDAO().getList()));
    }
}

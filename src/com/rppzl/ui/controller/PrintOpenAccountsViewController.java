package com.rppzl.ui.controller;

import com.rppzl.dao.PersonalAccountDAO;
import com.rppzl.entity.CreditAccount;
import com.rppzl.entity.PersonalAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class PrintOpenAccountsViewController {

/*    @FXML TableView<> openAccountsTableView;
    @FXML TableColumn<,String> accountNumberTableColumn;
    @FXML TableColumn<,Double> accountSumTableColumn;
    @FXML TableColumn<,Double> balanceTableColumn;
    @FXML TableColumn<,Double> procentTableColumn;
    @FXML TableColumn<,LocalDate> startDateTableColumn;*/

    public void changeSceneToAccountInfo(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/rppzl/ui/fxml/AccountView.fxml"));
            Parent signupViewParent = loader.load();

            Scene signupViewScene = new Scene(signupViewParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Счет клиента");
            window.setScene(signupViewScene);
            window.show();
        }
}

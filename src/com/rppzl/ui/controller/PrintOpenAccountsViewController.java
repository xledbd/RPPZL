package com.rppzl.ui.controller;

import com.rppzl.dao.CreditAccountDAO;
import com.rppzl.dao.DepositAccountDAO;
import com.rppzl.dao.PersonalAccountDAO;
import com.rppzl.entity.AccountInfo;
import com.rppzl.entity.CreditAccount;
import com.rppzl.entity.DepositAccount;
import com.rppzl.entity.PersonalAccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PrintOpenAccountsViewController implements Initializable {

    @FXML TableView<AccountInfo> openAccountsTableView;
    @FXML TableColumn<AccountInfo,String> accountNumberTableColumn;
    @FXML TableColumn<AccountInfo,String> accountSumTableColumn;
    @FXML TableColumn<AccountInfo,Double> balanceTableColumn;
    @FXML TableColumn<AccountInfo,Double> procentTableColumn;
    @FXML TableColumn<AccountInfo,LocalDate> startDateTableColumn;

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

    public ObservableList<AccountInfo> getList() {
        List<AccountInfo> list = new ArrayList<>();
        List<CreditAccount> creditAccounts = new CreditAccountDAO().getList().
                stream().filter(item -> item.getPersonalAccount().getId() == AccountViewController.account.getId())
                .collect(Collectors.toList());
        for (CreditAccount c : creditAccounts) {
            AccountInfo a = new AccountInfo();
            a.setName(c.getProduct().getName());
            a.setBalance(c.getSum());
            a.setDate(c.getStartDate());
            a.setNumber(c.getNumber());
            a.setRate(c.getProduct().getInterestRate());
            list.add(a);
        }
        List<DepositAccount> depositAccounts = new DepositAccountDAO().getList().
                stream().filter(item -> item.getPersonalAccount().getId() == AccountViewController.account.getId())
                .collect(Collectors.toList());
        for (DepositAccount d : depositAccounts) {
            AccountInfo a = new AccountInfo();
            a.setName(d.getProduct().getName());
            a.setBalance(d.getSum());
            a.setDate(d.getStartDate());
            a.setNumber(d.getNumber());
            a.setRate(d.getProduct().getInterestRate());
            list.add(a);
        }
        return FXCollections.observableArrayList(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        accountNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        accountSumTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        balanceTableColumn.setCellValueFactory(new PropertyValueFactory<>("balance"));
        procentTableColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
        startDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        openAccountsTableView.setItems(getList());
    }
}

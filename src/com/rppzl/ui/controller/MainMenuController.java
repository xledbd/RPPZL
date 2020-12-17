package com.rppzl.ui.controller;

import com.rppzl.dao.CreditAccountDAO;
import com.rppzl.dao.DepositAccountDAO;
import com.rppzl.entity.CreditAccount;
import com.rppzl.entity.DepositAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MainMenuController {
    @FXML private Button addButton;
    @FXML private Button editButton;
    @FXML private Button removeButton;
    @FXML private Button printButton;


    public void changeSceneToAddClientView(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/rppzl/ui/fxml/AddClientView.fxml"));
        Parent signupViewParent = loader.load();

        Scene signupViewScene = new Scene(signupViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Добавление клиента");
        window.setScene(signupViewScene);
        window.show();
    }

    public void changeSceneToEditClientView(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/rppzl/ui/fxml/EditClientView.fxml"));
        Parent signupViewParent = loader.load();

        Scene signupViewScene = new Scene(signupViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Редактирование клиента");
        window.setScene(signupViewScene);
        window.show();
    }

    public void changeSceneToRemoveClientView(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/rppzl/ui/fxml/RemoveClientView.fxml"));
        Parent signupViewParent = loader.load();

        Scene signupViewScene = new Scene(signupViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Удаление клиента");
        window.setScene(signupViewScene);
        window.show();
    }

    public void changeSceneToPrintClientView(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/rppzl/ui/fxml/PrintClientView.fxml"));
        Parent signupViewParent = loader.load();

        Scene signupViewScene = new Scene(signupViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Список клиентов");
        window.setScene(signupViewScene);
        window.show();
    }

    public void changeSceneToCreditMenuView(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/rppzl/ui/fxml/CreditMenuView.fxml"));
        Parent signupViewParent = loader.load();

        Scene signupViewScene = new Scene(signupViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Управление кредитами");
        window.setScene(signupViewScene);
        window.show();
    }

    public void changeSceneToDepositMenuView(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/rppzl/ui/fxml/DepositMenuView.fxml"));
        Parent signupViewParent = loader.load();

        Scene signupViewScene = new Scene(signupViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Управление вкладами");
        window.setScene(signupViewScene);
        window.show();
    }

    public void closeBankDayButtonPressed(ActionEvent event) throws IOException{
        List<DepositAccount> depositAccountList = new DepositAccountDAO().getList();
        for (DepositAccount d : depositAccountList) {
            Double rate = d.getProduct().getInterestRate() / 100 / 365;
            Double delta = d.getSum() * rate;
            d.setSum(d.getSum() + delta);
            new DepositAccountDAO().save(d);
        }
        List<CreditAccount> creditAccountList = new CreditAccountDAO().getList();
        for (CreditAccount c : creditAccountList) {
            Double rate = c.getProduct().getInterestRate() / 100 / 365;
            Double delta = c.getSum() * rate;
            c.setSum(c.getSum() - delta);
            new CreditAccountDAO().save(c);
        }
    }
}

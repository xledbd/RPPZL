package com.rppzl.ui.controller;

import com.rppzl.dao.ClientDAO;
import com.rppzl.dao.DAO;
import com.rppzl.dao.PersonalAccountDAO;
import com.rppzl.entity.Client;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class PrintClientViewController implements Initializable {

    @FXML private Button backToMenuButton;
    @FXML private Button editButton;
    @FXML private Button removeButton;
    @FXML private Button infoButton;
    @FXML private Button countButton;

    @FXML private TableView<Client> tableView;
    @FXML private TableColumn<Client, String> lastNameColumn;
    @FXML private TableColumn<Client, String> firstNameColumn;
    @FXML private TableColumn<Client, String> middleNameColumn;
    @FXML private TableColumn<Client, LocalDate> dateOfBirthColumn;
    @FXML private TableColumn<Client, String> passportSeriesColumn;
    @FXML private TableColumn<Client, String> passportNumberColumn;
    @FXML private TableColumn<Client, String> emailColumn;


    public void changeSceneToMainMenu(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/rppzl/ui/fxml/MainMenu.fxml"));
        Parent signupViewParent = loader.load();

        Scene signupViewScene = new Scene(signupViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Главное меню");
        window.setScene(signupViewScene);
        window.show();
    }

    public ObservableList<Client> getClientObservableList() {
        DAO<Client> dao = new ClientDAO();
        List<Client> list = dao.getList();
        return FXCollections.observableArrayList(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        middleNameColumn.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        passportSeriesColumn.setCellValueFactory(new PropertyValueFactory<>("passportSeries"));
        passportNumberColumn.setCellValueFactory(new PropertyValueFactory<>("passportNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        tableView.setItems(getClientObservableList());

        editButton.setVisible(false);
        removeButton.setVisible(false);
        infoButton.setVisible(false);
        countButton.setVisible(false);
    }

    public void tableRowSelected(MouseEvent event){
        Client client = tableView.getSelectionModel().getSelectedItem();
        if(client!=null){
            editButton.setVisible(true);
            removeButton.setVisible(true);
            infoButton.setVisible(true);
            countButton.setVisible(true);
        }
    }

    public void removeButtonPressed(ActionEvent event){
        Client client = tableView.getSelectionModel().getSelectedItem();
        DAO<Client> dao = new ClientDAO();
        dao.delete(client.getId());
        tableView.getItems().remove(client);
    }

    public void changeSceneToEditClientView(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/rppzl/ui/fxml/EditClientView.fxml"));
        Parent parent = loader.load();

        Scene signupViewScene = new Scene(parent);
        EditClientViewController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Редактирование клиента");
        window.setScene(signupViewScene);
        window.show();
    }

    public void changeSceneToPrintFullInfo(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/rppzl/ui/fxml/PrintFullInfo.fxml"));
        Parent parent = loader.load();

        Scene signupViewScene = new Scene(parent);
        PrintFullInfoController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Просмотр клиента");
        window.setScene(signupViewScene);
        window.show();
    }

    public void changeSceneToAccountInfo(ActionEvent event) throws IOException
    {
        List<PersonalAccount> list = new PersonalAccountDAO().getList();
        PersonalAccount account = null;
        for (PersonalAccount p : list) {
            if (tableView.getSelectionModel().getSelectedItem().getId() == p.getClient().getId()) {
                account = p;
            }
        }
        AccountViewController.account = account;

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


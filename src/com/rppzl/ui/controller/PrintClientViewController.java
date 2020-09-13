package com.rppzl.ui.controller;

import com.rppzl.dao.ClientDAO;
import com.rppzl.dao.DAO;
import com.rppzl.entity.Client;
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
    }

    public void tableRowSelected(MouseEvent event){
        Client client = tableView.getSelectionModel().getSelectedItem();
        if(client!=null){
            editButton.setVisible(true);
            removeButton.setVisible(true);
        }
    }

    public void removeButtonPressed(ActionEvent event){
        Client client = tableView.getSelectionModel().getSelectedItem();
        DAO<Client> dao = new ClientDAO();
        dao.delete(client.getId());
        tableView.getItems().remove(client);
    }
}


package com.rppzl.ui.controller;


import com.rppzl.dao.CreditProductDAO;
import com.rppzl.dao.DepositProductDAO;
import com.rppzl.entity.CreditProduct;
import com.rppzl.entity.DepositProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class CreditMenuViewController implements Initializable {

    @FXML private TableView<CreditProduct> tableView;
    @FXML private TableColumn<CreditProduct, String> nameColumn;
    @FXML private TableColumn<CreditProduct, String> rateColumn;

    @FXML private TextField nameField;
    @FXML private TextField rateField;
    @FXML private Label addLabel;

    @FXML private VBox editVBox;
    @FXML private TextField nameFieldEdit;
    @FXML private TextField rateFieldEdit;
    @FXML private Label editLabel;

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

    public void addButtonPressed(ActionEvent event) throws Exception {
        String name = nameField.getText();
        double rate = Double.parseDouble(rateField.getText());
        if (!name.isEmpty()) {
            CreditProduct product = new CreditProduct();
            product.setId(new DepositProductDAO().getList().size() + 1);
            product.setName(name);
            product.setInterestRate(rate);
            new CreditProductDAO().save(product);
            addLabel.setText("Услуга добавлена");
            addLabel.setTextFill(Color.GREEN);
            tableView.setItems(getServiceObservableList());

            addLabel.setVisible(true);
        }
        nameField.clear();
        rateField.clear();
    }

    public void tableRowSelected(MouseEvent event) {
        CreditProduct product = tableView.getSelectionModel().getSelectedItem();
        if (product != null) {
            editVBox.setVisible(true);
            editLabel.setVisible(false);
            nameFieldEdit.setText(product.getName());
            rateFieldEdit.setText(Double.toString(product.getInterestRate()));
        }
    }

    public void editButtonPressed(ActionEvent event) throws Exception {
        CreditProduct product = tableView.getSelectionModel().getSelectedItem();
        String name = nameFieldEdit.getText();
        double rate = Double.parseDouble(rateFieldEdit.getText());
        if (!name.isEmpty()) {
            CreditProduct send = new CreditProduct();
            send.setName(name);
            send.setInterestRate(rate);
            send.setId(product.getId());
            new CreditProductDAO().save(send);
            tableView.setItems(getServiceObservableList());
            editLabel.setText("Изменения сохранены");
            editLabel.setTextFill(Color.GREEN);
            editLabel.setVisible(true);
        }
    }

    public void removeButtonPressed(ActionEvent event) throws Exception {
        CreditProduct product = tableView.getSelectionModel().getSelectedItem();
        new CreditProductDAO().delete(product.getId());
        tableView.setItems(getServiceObservableList());
        editLabel.setText("Запись удалена");
        editLabel.setTextFill(Color.GREEN);

        editLabel.setVisible(true);
    }



    public static ObservableList<CreditProduct> getServiceObservableList() {
        return FXCollections.observableArrayList(new CreditProductDAO().getList());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        rateColumn.setCellValueFactory(new PropertyValueFactory<>("interestRate"));

        tableView.setItems(getServiceObservableList());

        tableView.getSortOrder().add(nameColumn);

        editVBox.setVisible(false);
    }
    }

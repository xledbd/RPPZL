package com.rppzl.ui.controller;


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

       /* @FXML private TableView<Service> tableView;
        @FXML private TableColumn<Service, String> nameColumn;
        @FXML private TableColumn<Service, String> priceColumn;*/

        @FXML private TextField nameField;
        @FXML private TextField priceField;
        @FXML private TextArea descriptionField;
        @FXML private Label addLabel;

        @FXML private VBox editVBox;
        @FXML private TextField nameFieldEdit;
        @FXML private TextField priceFieldEdit;
        @FXML private TextArea descriptionFieldEdit;
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
            /*String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            String description = descriptionField.getText();
            if (!name.isEmpty()) {
                Service service = new Service(name, price);
                service.setDescription(description);
                App.outputStream.writeObject("add_service");
                App.outputStream.writeObject(service);
                String b = (String) App.inputStream.readObject();
                if (b.equals("true")) {
                    addLabel.setText("Услуга добавлена");
                    addLabel.setTextFill(Color.GREEN);
                    tableView.setItems(getServiceObservableList());
                } else {
                    addLabel.setText("Ошибка при добавлени блюда");
                    addLabel.setTextFill(Color.RED);
                }
                addLabel.setVisible(true);
            }
            nameField.clear();
            priceField.clear();
            descriptionField.clear();*/
        }

        public void tableRowSelected(MouseEvent event) {
           /* Service service = tableView.getSelectionModel().getSelectedItem();
            if (service != null) {
                editVBox.setVisible(true);
                editLabel.setVisible(false);
                nameFieldEdit.setText(service.getName());
                priceFieldEdit.setText(Double.toString(service.getPrice()));
                descriptionFieldEdit.setText(service.getDescription());
            }*/
        }

        public void editButtonPressed(ActionEvent event) throws Exception {
           /* Service service = tableView.getSelectionModel().getSelectedItem();
            String name = nameFieldEdit.getText();
            double price = Double.parseDouble(priceFieldEdit.getText());
            String desc = descriptionFieldEdit.getText();
            if (!name.isEmpty()) {
                Service send = new Service(name, price);
                send.setDescription(desc);
                send.setId(service.getId());
                App.outputStream.writeObject("edit_service");
                App.outputStream.writeObject(send);
                String b = (String) App.inputStream.readObject();
                if (b.equals("true"))
                {
                    tableView.setItems(getServiceObservableList());
                    editLabel.setText("Изменения сохранены");
                    editLabel.setTextFill(Color.GREEN);
                }
                else
                {
                    editLabel.setText("Ошибка при сохранении изменений");
                    editLabel.setTextFill(Color.RED);
                }
                editLabel.setVisible(true);
            }*/
        }

        public void removeButtonPressed(ActionEvent event) throws Exception {
            /*Service service = tableView.getSelectionModel().getSelectedItem();
            App.outputStream.writeObject("remove_service");
            App.outputStream.writeObject(service.getId());
            String b = (String) App.inputStream.readObject();
            if (b.equals("true")) {
                tableView.setItems(getServiceObservableList());
                editLabel.setText("Запись удалена");
                editLabel.setTextFill(Color.GREEN);
            }
            else {
                editLabel.setText("Ошибка при удалении записи");
                editLabel.setTextFill(Color.RED);
            }
            editLabel.setVisible(true);*/
        }



        /*public static ObservableList<Service> getServiceObservableList() {
           *//* List<Service> list = null;
            try {
                App.outputStream.writeObject("get_services");
                list = (List<Service>) App.inputStream.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return FXCollections.observableArrayList(list);*//*
        }*/

        @Override
        public void initialize(URL location, ResourceBundle resources) {
           /* nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

            tableView.setItems(getServiceObservableList());

            tableView.getSortOrder().add(nameColumn);

            editVBox.setVisible(false);*/
        }
    }

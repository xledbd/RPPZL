package com.rppzl.ui.controller;

import com.rppzl.dao.CityDAO;
import com.rppzl.dao.CountryDAO;
import com.rppzl.dao.DAO;
import com.rppzl.entity.City;
import com.rppzl.entity.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddCityViewController implements Initializable {

    private Stage stage;

    @FXML private TextField nameField;
    @FXML private ChoiceBox<Country> countryChoiceBox;

    public void saveButtonPressed(ActionEvent event) {
        String name = nameField.getText();
        Country country = countryChoiceBox.getValue();

        if (country != null && !name.isEmpty()) {
            City city = new City(name);
            city.setCountry(country);
            DAO<City> dao = new CityDAO();
            dao.save(city);
        }
        stage.close();
    }

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

    public ObservableList<Country> getCountryObservableList() {
        DAO<Country> dao = new CountryDAO();
        List<Country> list = dao.getList();
        return FXCollections.observableArrayList(list);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        countryChoiceBox.setItems(getCountryObservableList());
    }
}

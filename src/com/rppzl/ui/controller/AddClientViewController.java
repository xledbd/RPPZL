package com.rppzl.ui.controller;

import com.rppzl.dao.CityDAO;
import com.rppzl.dao.CountryDAO;
import com.rppzl.dao.DAO;
import com.rppzl.entity.City;
import com.rppzl.entity.Client;
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
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddClientViewController implements Initializable {

    @FXML private Button backToMenuButton;
    @FXML private Button addButton;

    @FXML private TextField lastNameField;
    @FXML private TextField firstNameField;
    @FXML private TextField middleNameField;
    @FXML private DatePicker dateOfBirthField;
    @FXML private TextField passportSeriesField;
    @FXML private TextField passportNumberField;
    @FXML private TextField authorityField;
    @FXML private DatePicker dateOfIssueField;
    @FXML private TextField identificationNumberField;
    @FXML private TextField placeOfBirthField;
    @FXML private ChoiceBox<City> cityOfResidenceChoiceBox;
    @FXML private TextField addressOfResidenceField;
    @FXML private TextField landlinePhoneField;
    @FXML private TextField mobilePhoneField;
    @FXML private TextField emailField;
    @FXML private TextField placeOfWorkField;
    @FXML private TextField positionField;
    @FXML private ChoiceBox<City> cityOfRegistrationChoiceBox;
    @FXML private ChoiceBox<String> familyStatusChoiceBox;
    @FXML private ChoiceBox<Country> citizenshipChoiceBox;
    @FXML private ChoiceBox<String> disabilityChoiceBox;
    @FXML private CheckBox retireeCheckBox;
    @FXML private TextField monthlyIncomeField;


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

    public void addButtonPressed(ActionEvent event) {
        Client client = new Client();
        client.setLastName(lastNameField.getText());
        client.setFirstName(firstNameField.getText());
        client.setMiddleName(middleNameField.getText());
        client.setDateOfBirth(dateOfBirthField.getValue());
        client.setPassportSeries(passportSeriesField.getText());
        client.setPassportNumber(passportNumberField.getText());
        client.setAuthority(authorityField.getText());
        client.setDateOfIssue(dateOfIssueField.getValue());
        client.setIdentificationNumber(identificationNumberField.getText());
        client.setPlaceOfBirth(placeOfBirthField.getText());
        client.setCityOfResidence(cityOfResidenceChoiceBox.getValue());
        client.setAddress(addressOfResidenceField.getText());
        client.setLandlinePhone(landlinePhoneField.getText());
        client.setMobilePhone(mobilePhoneField.getText());
        client.setEmail(emailField.getText());
        client.setPlaceOfWork(placeOfWorkField.getText());
        client.setPosition(positionField.getText());
        client.setCityOfRegistration(cityOfRegistrationChoiceBox.getValue());
        client.setFamilyStatus(familyStatusChoiceBox.getValue());
        client.setCitizenship(citizenshipChoiceBox.getValue());
        client.setDisability(disabilityChoiceBox.getValue());
        client.setRetired(retireeCheckBox.isSelected());
        client.setMonthlyIncome(new BigDecimal(monthlyIncomeField.getText()));

    }

    public ObservableList<City> getCityObservableList() {
        DAO<City> dao = new CityDAO();
        List<City> list = dao.getList();
        return FXCollections.observableArrayList(list);
    }

    public ObservableList<Country> getCountryObservableList() {
        DAO<Country> dao = new CountryDAO();
        List<Country> list = dao.getList();
        return FXCollections.observableArrayList(list);
    }

    private void setFamilyStatusChoiceBoxItems() {
        familyStatusChoiceBox.getItems().add("Женат/замужем");
        familyStatusChoiceBox.getItems().add("Не женат/не замужем");
    }

    private void setDisabilityChoiceBoxItems() {
        disabilityChoiceBox.getItems().add("Отсутствует");
        disabilityChoiceBox.getItems().add("I группа");
        disabilityChoiceBox.getItems().add("II группа");
        disabilityChoiceBox.getItems().add("III группа");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<City> observableList = getCityObservableList();
        cityOfResidenceChoiceBox.setItems(observableList);
        cityOfRegistrationChoiceBox.setItems(observableList);
        citizenshipChoiceBox.setItems(getCountryObservableList());

        setFamilyStatusChoiceBoxItems();
        setDisabilityChoiceBoxItems();

    }
}

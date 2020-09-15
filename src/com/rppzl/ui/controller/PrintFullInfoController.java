package com.rppzl.ui.controller;

import com.rppzl.dao.CityDAO;
import com.rppzl.dao.ClientDAO;
import com.rppzl.dao.CountryDAO;
import com.rppzl.dao.DAO;
import com.rppzl.entity.City;
import com.rppzl.entity.Client;
import com.rppzl.entity.ConstraintValidator;
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

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class PrintFullInfoController {
    private Client client;

    @FXML private Button backButton;

    @FXML private TextField lastNameField;
    @FXML private TextField firstNameField;
    @FXML private TextField middleNameField;
    @FXML private TextField dateOfBirthField;
    @FXML private TextField passportSeriesField;
    @FXML private TextField passportNumberField;
    @FXML private TextField authorityField;
    @FXML private TextField dateOfIssueField;
    @FXML private TextField identificationNumberField;
    @FXML private TextField placeOfBirthField;
    @FXML private TextField cityOfResidenceField;
    @FXML private TextField addressOfResidenceField;
    @FXML private TextField landlinePhoneField;
    @FXML private TextField mobilePhoneField;
    @FXML private TextField emailField;
    @FXML private TextField placeOfWorkField;
    @FXML private TextField positionField;
    @FXML private TextField cityOfRegistrationField;
    @FXML private TextField familyStatusField;
    @FXML private TextField citizenshipField;
    @FXML private TextField disabilityField;
    @FXML private CheckBox retireeCheckBox;
    @FXML private TextField monthlyIncomeField;



    public void changeSceneToPrintClientView(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/rppzl/ui/fxml/PrintClientView.fxml"));
        Parent signupViewParent = loader.load();

        Scene signupViewScene = new Scene(signupViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Главное меню");
        window.setScene(signupViewScene);
        window.show();
    }

    public void initData(Client client){
        this.client=client;
        lastNameField.setText(client.getLastName());
        firstNameField.setText(client.getFirstName());
        middleNameField.setText(client.getMiddleName());
        dateOfBirthField.setText(client.getDateOfBirth().toString());
        passportSeriesField.setText(client.getPassportSeries());
        passportNumberField.setText(client.getPassportNumber());
        authorityField.setText(client.getAuthority());
        dateOfIssueField.setText(client.getDateOfIssue().toString());
        identificationNumberField.setText(client.getIdentificationNumber());
        placeOfBirthField.setText(client.getPlaceOfBirth());
        cityOfResidenceField.setText(client.getCityOfResidence().toString());
        addressOfResidenceField.setText(client.getAddress());
        landlinePhoneField.setText(client.getLandlinePhone());
        mobilePhoneField.setText(client.getMobilePhone());
        emailField.setText(client.getEmail());
        placeOfWorkField.setText(client.getPlaceOfWork());
        positionField.setText(client.getPosition());
        cityOfRegistrationField.setText(client.getCityOfRegistration().toString());
        familyStatusField.setText(client.getFamilyStatus().toString());
        citizenshipField.setText(client.getCitizenship().toString());
        disabilityField.setText(client.getDisability().toString());
        retireeCheckBox.setSelected(client.isRetired());
        monthlyIncomeField.setText(client.getMonthlyIncome().toString());

        lastNameField.setEditable(false);
        firstNameField.setEditable(false);
        middleNameField.setEditable(false);
        dateOfBirthField.setEditable(false);
        passportSeriesField.setEditable(false);
        passportNumberField.setEditable(false);
        authorityField.setEditable(false);

        dateOfIssueField.setEditable(false);
        identificationNumberField.setEditable(false);
        placeOfBirthField.setEditable(false);
        cityOfResidenceField.setEditable(false);
        addressOfResidenceField.setEditable(false);
        landlinePhoneField.setEditable(false);
        mobilePhoneField.setEditable(false);
        emailField.setEditable(false);
        placeOfWorkField.setEditable(false);
        positionField.setEditable(false);
        cityOfRegistrationField.setEditable(false);
        familyStatusField.setEditable(false);
        citizenshipField.setEditable(false);
        disabilityField.setEditable(false);
       // retireeCheckBox.
        monthlyIncomeField.setEditable(false);


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
}
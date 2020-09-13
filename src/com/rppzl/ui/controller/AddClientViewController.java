package com.rppzl.ui.controller;

import com.rppzl.entity.City;
import com.rppzl.entity.Country;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AddClientViewController {

    @FXML private Button backToMenuButton;

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
}

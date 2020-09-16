package com.rppzl.ui.controller;

import com.rppzl.dao.CountryDAO;
import com.rppzl.dao.DAO;
import com.rppzl.entity.Country;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCountryViewController {

	private Stage stage;

	@FXML private TextField countryField;
	@FXML private TextField citizenshipField;

	public void saveButtonPressed(ActionEvent event) {
		String country = countryField.getText();
		String citizenship = citizenshipField.getText();

		if (!country.isEmpty() && !citizenship.isEmpty()) {
			DAO<Country> dao = new CountryDAO();
			dao.save(new Country(country, citizenship));
		}
		stage.close();
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}

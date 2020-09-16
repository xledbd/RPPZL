package com.rppzl.ui.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class AddClientErrorPopupWindowController {

	private Stage stage;

	public void okButtonPressed(ActionEvent event) {
		stage.close();
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}

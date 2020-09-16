package com.rppzl.ui.controller;

import com.rppzl.entity.Client;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ErrorPopupWindowController {

	@FXML private TableView<ConstraintViolation<Client>> tableView;
	@FXML private TableColumn<ConstraintViolation<Client>, String> tableColumn;

	public void initData(Set<ConstraintViolation<Client>> set) {
		tableColumn.setCellValueFactory(new PropertyValueFactory<>("message"));
		tableView.setItems(FXCollections.observableArrayList(set));
	}
}

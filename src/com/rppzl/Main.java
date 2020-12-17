package com.rppzl;

import com.rppzl.db.SessionFactorySingleton;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		SessionFactorySingleton.getInstance();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("com/rppzl/ui/fxml/MainMenu.fxml"));
		Scene scene = new Scene(root);

		primaryStage.setTitle("Добро пожаловать");
		primaryStage.setScene(scene);
		primaryStage.show();


	}
}

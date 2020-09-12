package com.rppzl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
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

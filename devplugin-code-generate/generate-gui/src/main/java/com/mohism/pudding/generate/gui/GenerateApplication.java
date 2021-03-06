package com.mohism.pudding.generate.gui;

import com.mohism.pudding.generate.gui.panel.controller.MainUIController;
import com.mohism.pudding.generate.gui.util.ConfigHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

/**
 * 这是本软件的主入口,要运行本软件请直接运行本类就可以了,不用传入任何参数
 * 本软件要求jkd版本大于1.8.0.40
 */
public class GenerateApplication extends Application {

	private static final Logger _LOG = LoggerFactory.getLogger(GenerateApplication.class);

	@Override
	public void start(Stage primaryStage) throws Exception {
		ConfigHelper.createEmptyFiles();
		URL url = Thread.currentThread().getContextClassLoader().getResource("fxml/MainUI.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(url);
		Parent root = fxmlLoader.load();
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
        // 加载 mainUI
		MainUIController controller = fxmlLoader.getController();
		controller.setPrimaryStage(primaryStage);
	}
	public static void main(String[] args) {
		launch(args);
	}

}

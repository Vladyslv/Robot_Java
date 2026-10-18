package com.example.du04_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load());
        HelloController controller = loader.getController();

        scene.setOnKeyPressed(e -> controller.klavesa(e));


        stage.setTitle("Robot!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}

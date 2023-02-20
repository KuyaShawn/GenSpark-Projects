package com.example.project_8_human_vs_goblins_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Testing Purpose
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        // Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Group root = new Group();
        Scene scene = new Scene(root, Color.BLACK);
        Image icon = new Image("C:\\Users\\Big Daddy\\Documents\\GitHub\\GenSpark-Projects\\project_8_human_vs_goblins_GUI\\src\\main\\resources\\com\\example\\project_8_human_vs_goblins_gui\\goblins-vs-skeletons.jpg");

        stage.getIcons().add(icon);
        stage.setTitle("Human Vs Goblin");
        stage.setWidth(640);
        stage.setHeight(720);
        stage.setResizable(false);
        stage.setFullScreen(false);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
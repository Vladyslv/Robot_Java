package com.example.du04_1;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    @FXML private AnchorPane pane;
    private Robot robot;
    private AnimationTimer casovac;

    @FXML public void initialize() {
        robot = new Robot(pane.getPrefWidth(), pane.getPrefHeight());
        pane.getChildren().add(robot);
        robot.setOnMouseClicked(e -> robot.prepniRezim());
        casovac = new AnimationTimer() {
            public void handle(long now) {
                robot.autoKrok();
            }
        };
    }

    @FXML private void prepniRezim() {
        robot.prepniRezim();
        if(robot.isAuto()) {
            casovac.start();
        } else {
            casovac.stop();
        }
    }

    public void klavesa(KeyEvent e) {
        if(robot.isAuto()) return;
        switch (e.getCode()) {
            case W -> robot.posun("UP");
            case A -> robot.posun("LEFT");
            case S -> robot.posun("DOWN");
            case D -> robot.posun("RIGHT");
        }
    }

}

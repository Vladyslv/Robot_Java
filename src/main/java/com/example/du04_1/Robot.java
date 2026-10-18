package com.example.du04_1;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Robot extends Rectangle{
    private String smer = "RIGHT";
    private boolean auto = false;
    private double vyskaPlochy;
    private double sirkaPlochy;
    private double krok = 5;

    public Robot(double sirkaPlochy, double vyskaPlochy) {
        super(50, 50,60, 40);
        this.sirkaPlochy = sirkaPlochy;
        this.vyskaPlochy = vyskaPlochy;
        otoc("RIGHT");
    }

    public void otoc(String novySmer) {
        smer = novySmer;
        if (smer.equals("LEFT") || smer.equals("RIGHT")) {
            setWidth(60);
            setHeight(40);
        } else {
            setWidth(40);
            setHeight(60);
        }
        if (smer.equals("LEFT")) setFill(Color.RED);
        if (smer.equals("RIGHT")) setFill(Color.GREEN);
        if (smer.equals("UP")) setFill(Color.BLUE);
        if (smer.equals("DOWN")) setFill(Color.ORANGE);
        zostanVnutri();
    }

    public void posun(String novySmer) {
        otoc(novySmer);
        if(smer.equals("LEFT")) setX(getX() - krok);
        if(smer.equals("RIGHT")) setX(getX() + krok);
        if(smer.equals("UP")) setY(getY() - krok);
        if(smer.equals("DOWN")) setY(getY() + krok);
        zostanVnutri();
    }

    public void autoKrok() {
        posun(smer);
        if(smer.equals("LEFT") && getX() <= 0) otoc("RIGHT");
        else if (smer.equals("RIGHT") && getX() + getWidth() >= sirkaPlochy) otoc("LEFT");
        else if (smer.equals("UP") && getY() <=0) otoc("DOWN");
        else if (smer.equals("DOWN") && getY() + getHeight() >= vyskaPlochy) otoc("UP");
    }

    public boolean isAuto() {
        return auto;
    }

    public void prepniRezim() {
        auto = !auto;
    }

    private void zostanVnutri() {
        if(getX() < 0) setX(0);
        if(getX() + getWidth() > sirkaPlochy) setX(sirkaPlochy - getWidth());
        if(getY() < 0) setY(0);
        if(getY() + getHeight() > vyskaPlochy) setY(vyskaPlochy - getHeight());
    }
}

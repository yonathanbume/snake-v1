package com.unamba.appdeskgame;

import java.awt.Color;
import javax.swing.JButton;

public final class Eat {

    public JButton snack;
    public int positionX;
    public int positionY;

    public final int dimension = 20;

    public Eat() {
        snack = new JButton();

        //  newPosition();
        snack.setBackground(Color.WHITE);
        snack.setEnabled(false);
    }

    public void newPosition() {
        positionX = (int) Math.floor(Math.random() * ((GameParam.jFrameWidth - dimension) - 0 + 1)) + 0;
        positionY = (int) Math.floor(Math.random() * ((GameParam.jFrameHeight - dimension) - GameParam.POSITIONYINIT + 1)) + GameParam.POSITIONYINIT;

        snack.setBounds(positionX, positionY, dimension, dimension);
    }
}

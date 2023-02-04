package com.unamba.appdeskgame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

public class Snake {

    public static List<SnakeBody> body;
    private static final int bodyDimension = 20;

    public Snake() {
    }

    public static void incrementBody(int posX, int posY) {
        JButton btnTemp = new JButton();

        btnTemp.setBounds(posX, posY, bodyDimension, bodyDimension);
        btnTemp.setEnabled(false);
        btnTemp.setBackground(Color.YELLOW);

        SnakeBody snakeBody = new SnakeBody();

        snakeBody.setBodySection(btnTemp);
        snakeBody.setPositionX(posX);
        snakeBody.setPositionY(posY);

        Snake.body.add(snakeBody);
    }

    public Snake(int bodyElementQuantity) {
        Snake.body = new ArrayList<>();

        for (int i = 0; i < bodyElementQuantity; i++) {
            // JButton btnTemp = new JButton();
            int posX = 0;
            int posY = GameParam.POSITIONYINIT;
            incrementBody(posX, posY);
        }
    }
}

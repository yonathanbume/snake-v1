package com.unamba.appdeskgame;

import javax.swing.JButton;

public class SnakeBody {

    private JButton bodySection;
    private int positionX;
    private int positionY;

    public void setBounds() {
        bodySection.setBounds(positionX, positionY, bodySection.getWidth(), bodySection.getHeight());
    }

    public void setBounds(int x, int y) {
        bodySection.setBounds(x, y, bodySection.getWidth(), bodySection.getHeight());
    }

    public void setBodySection(JButton bodySection) {
        this.bodySection = bodySection;
    }

    public JButton getBodySection() {
        return bodySection;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionY() {
        return positionY;
    }
}

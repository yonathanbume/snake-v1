package com.unamba.appdeskgame;

import java.awt.Color;
import javax.swing.JFrame;

public class Main {

    public static FrmPrincipal frmPrincipal = new FrmPrincipal();

    public static void main(String[] args) {
        // FrmPrincipal frmPrincipal = new FrmPrincipal();

        frmPrincipal.getContentPane().setBackground(Color.BLACK);
        frmPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frmPrincipal.setVisible(true);

        GameParam.jFrameWidth = frmPrincipal.getSize().width;
        GameParam.jFrameHeight = frmPrincipal.getSize().height;

        Snake snake = new Snake(1);

        for (SnakeBody item : snake.body) {
            frmPrincipal.getContentPane().add(item.getBodySection());
        }

        LogicProcess logicProcess = new LogicProcess(snake);

        logicProcess.start();

        Eat eat = new Eat();

        frmPrincipal.getContentPane().add(eat.snack);

        SnackProcess snackProcess = new SnackProcess(eat, frmPrincipal.lblRandomPosition);

        snackProcess.start();

    }
}

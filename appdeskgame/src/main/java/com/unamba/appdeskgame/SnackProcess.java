package com.unamba.appdeskgame;

import javax.swing.JLabel;

public class SnackProcess extends Thread {

    private Eat eat;
    private JLabel lblRandomPosition;

    public SnackProcess() {
    }

    public SnackProcess(Eat eat, JLabel lblRandomPosition) {
        this.eat = eat;
        this.lblRandomPosition = lblRandomPosition;
    }

    public boolean colision() {
        boolean x = this.eat.positionX - 20 < GameParam.positionHeadX && this.eat.positionX + 20 > GameParam.positionHeadX;
        boolean y = this.eat.positionY - 20 < GameParam.positionHeadY && this.eat.positionY + 20 > GameParam.positionHeadY;
        return x && y;
    }

    @Override
    public void run() {
        for (;;) {
            boolean hayColision = colision();
            if (hayColision) {
                SnakeBody cola = Snake.body.get(Snake.body.size() - 1);
                int posx = cola.getPositionX();
                int posy = cola.getPositionY();

                Snake.incrementBody(posx, posy);
                cola = Snake.body.get(Snake.body.size() - 1);
                Main.frmPrincipal.getContentPane().add(cola.getBodySection());
            }
            if (GameParam.timerRandom == 0 || hayColision) {
                eat.newPosition();
                GameParam.timerRandom = 12;
            }

            lblRandomPosition.setText("Random pos: " + GameParam.timerRandom + "s");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            GameParam.timerRandom -= 1;
        }
    }
}

package com.unamba.appdeskgame;

/**
 *
 * @author kaaf030191
 */
public class LogicProcess extends Thread {

    private Snake snake;
    private int posX;
    private int posY;
    private final int moveX = 20;
    private final int moveY = 20;
    private boolean isHead;

    private int oldPositionX;
    private int oldPositionY;

    private int oldPositionXTemp;
    private int oldPositionYTemp;

    public LogicProcess() {
    }

    public LogicProcess(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void run() {
        for (;;) {
            posX = GameParam.positionX;
            posY = GameParam.positionY;
            isHead = true;

            for (SnakeBody item : Snake.body) {
                oldPositionX = item.getPositionX();
                oldPositionY = item.getPositionY();

                if (isHead) {
                    if (item.getPositionX() < posX) {
                        item.setPositionX(item.getPositionX() + moveX);
                    }

                    if (item.getPositionY() < posY) {
                        item.setPositionY(item.getPositionY() + moveY);
                    }

                    if (item.getPositionX() > posX) {
                        item.setPositionX(item.getPositionX() - moveX);
                    }

                    if (item.getPositionY() > posY) {
                        item.setPositionY(item.getPositionY() - moveY);
                    }

                    isHead = false;
                } else {
                    item.setPositionX(oldPositionXTemp);
                    item.setPositionY(oldPositionYTemp);
                }

                oldPositionXTemp = oldPositionX;
                oldPositionYTemp = oldPositionY;

                item.setBounds();
            }
            //se gurda la posion de head en cada momento
            GameParam.positionHeadX = snake.body.get(0).getPositionX();
            GameParam.positionHeadY = snake.body.get(0).getPositionY();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}

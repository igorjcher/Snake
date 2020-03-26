package view;

import model.FoodManager;
import model.FoodManagerImpl;
import java.awt.Color;
import model.Snake;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import model.Direction;
import model.Food;

public class SnakePanel extends JPanel implements Runnable, KeyListener {

    public static final int CELL_SIZE = 20;

    private Food food;
    private Snake snake;
    private FoodManager foodManager;
    private Thread thread;
    private Direction direction;
    private volatile boolean isOver = false; // компилятор запрещает помещать переменную в кэш потока
    private int speed = 400;

    public void initNewGame() {
        snake = new Snake();
        foodManager = new FoodManagerImpl();
        food = foodManager.generateFood(snake);
        thread = new Thread(this);
        thread.start();
        isOver = false;
        setBackground(Color.DARK_GRAY);
        //System.out.println("INITIALIZED NEW GAME");
    }
    
    public void stopGame() {
        thread.interrupt();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g);
        food.draw(g);
    }

    public void increaseSpeed() {
        speed = 200;
    }

    public void makeNormalSpeed() {
        speed = 400;
    }

    @Override
    public void run() {
        System.out.println("Main loop started...");
        while (!isOver) {
            if (!snake.canGo() || snake.isContainedSnake()) {
                isOver = true;
                break;
            }
            
            try {
                if (snake.canEat(food)) {
                    snake.eatFood(food.getFood());
                    food = foodManager.generateFood(snake);
                }
                snake.makeStep();
                repaint();
                Thread.sleep(speed);
            } catch (InterruptedException ex) {
                //ex.printStackTrace();
                System.out.println("Main loop was interrupted while sleeping...");
                break;
            }
        }
        
        System.out.println("Main loop stopped...");
        if (isOver) {
            System.out.println("Game over... :(");
            initNewGame();
        }
    }
    
//    public void join() {
//        thread.join();
//    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPrssed: " + Thread.currentThread().getName());
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                snake.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                snake.setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                snake.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                snake.setDirection(Direction.RIGHT);
                break;
            default:
                snake.setDirection(Direction.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

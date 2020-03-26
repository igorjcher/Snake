package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import view.SnakePanel;
import static view.SnakePanel.CELL_SIZE;

public class Snake {

    private List<Point> snake;
    private Direction direction = Direction.RIGHT;

    public Snake() {
        this.snake = new ArrayList<>();
        snake.add(new Point(4, 4));
    }
//
//    public void goLeft() {
//        snake.get(0).x--;
//    }
//
//    public void goRight() {
//        snake.get(0).x++;
//    }
//
//    public void goDown() {
//        snake.get(0).y++;
//    }
//
//    public void goUp() {
//        snake.get(0).y--;
//    }

    public void eatFood(Point point) {
        snake.add(0, point);
        System.out.println("isEated " + snake.size());
    }

    public boolean canEat(Food food) {
        int x = food.getFood().x;
        int y = food.getFood().y;

        return x == snake.get(0).x && y == snake.get(0).y;
    }

    public void makeStep() {

//        switch (direction) {
//            case LEFT:
//                goLeft();
//                break;
//            case RIGHT:
//
//                break;
//            case UP:
//                goUp();
//                break;
//            case DOWN:
//                goDown();
//                break;
//            default:
//                return;
//        }
//        snake.add(0, point);
//        snake.remove(snake.size() - 1);
        Point tail = snake.get(snake.size() - 1);
        int tailIndex = snake.size() - 1;
        System.out.println("tail = " + tail);
        Point head = snake.get(0);
        snake.remove(tailIndex);
        tail.x = head.x;
        tail.y = head.y;

        direction.move(tail);
        snake.add(0, tail);
    }

    public boolean canGo() {
        return !(snake.get(0).x >= SnakePanel.CELL_SIZE ||
                 snake.get(0).y >= SnakePanel.CELL_SIZE ||
                 snake.get(0).x < 0 || snake.get(0).y < 0);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isClashed() {
        for (int i = 1; i < snake.size(); i++) {

        }
        return true;
    }

    public boolean isContained(int x, int y) {
        for (int i = 0; i < snake.size(); i++) {
            if (snake.get(i).x != x & snake.get(i).y != y) {
                return true;
            }
        }
        return false;
    }

    public boolean isContainedSnake() {
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        for (int i = 0; i < snake.size(); i++) {
            g.fillOval(snake.get(i).x * CELL_SIZE, snake.get(i).y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            System.out.println("snake.getSnake().get(i).x " + snake.get(i).x + "  " + snake.get(i).y);
        }
    }
}

/*       
goRight situation
        Point tail = snake.get(snake.size() - 1);
        Point head = snake.get(0);
        snake.remove(snake.size() - 1);

        tail.x = head.x;
        tail.y = head.y;
        System.out.println("head.x == " + head.x + "tail.x == " + tail.x + "tail.y == " + tail.y);
        
        snake.add(0, tail);
*/

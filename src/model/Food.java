package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import static view.SnakePanel.CELL_SIZE;

public class Food {

    private Point foodPoints;

    public Food(int x, int y) {
        foodPoints = new Point(x, y);
    }

    public Point getFood() {
        return foodPoints;
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(foodPoints.x * CELL_SIZE, foodPoints.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }
}

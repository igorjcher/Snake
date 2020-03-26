package model;

import java.awt.Point;

public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private int dx;
    private int dy;

    private Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
    
    public void move(Point tail) {
        tail.x = tail.x + dx;
        tail.y = tail.y + dy;
    }
}

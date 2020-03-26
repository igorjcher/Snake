package model;

import java.util.Random;
import view.SnakePanel;

public class FoodManagerImpl implements FoodManager {

    private Random random;

    public FoodManagerImpl() {
        random = new Random();
    }

    @Override
    public Food generateFood(Snake snake) {
        while (true) {
            int x = random.nextInt(SnakePanel.CELL_SIZE);
            int y = random.nextInt(SnakePanel.CELL_SIZE);

            if (snake.isContained(x, y) || x >= SnakePanel.CELL_SIZE || y >= SnakePanel.CELL_SIZE || x < 0 || y < 0 ) {
                return new Food(x, y);
            }
        }
    }
}

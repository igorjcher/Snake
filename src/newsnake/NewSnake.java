package newsnake;

import javax.swing.SwingUtilities;
import view.SnakePanel;
import view.GameGrid;

/*
 * Author: Igor Chernenko.
 * Date: 29.02.2020.
 */

public class NewSnake {

    public static void main(String[] args) throws Exception {
        System.out.println("Main thread started...");
        SwingUtilities.invokeLater(() -> {
            SnakePanel snakePanel = new SnakePanel();
            
            GameGrid gameGrid = new GameGrid(snakePanel);
        });
        System.out.println("Main thread stopped...");
    }
}

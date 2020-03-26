package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameGrid extends JFrame {

    private SnakePanel snakePanel;

    public GameGrid(SnakePanel snakePanel) {
        this.snakePanel = snakePanel;
        setTitle("Title");
        setSize(SnakePanel.CELL_SIZE * 22, SnakePanel.CELL_SIZE * 23);
        addKeyListener(snakePanel);
        setLayout(new BorderLayout());
        add(snakePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        snakePanel.initNewGame();
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createMenu());
        setJMenuBar(menuBar);
        //menuBar.add(new JLabel("Your scores"));
        setVisible(true);
    }

    private JMenu createMenu() {
        JMenu mainMenu = new JMenu("Menu");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem newGame = new JMenuItem("Start New Game");
        JMenuItem increaseSpeed = new JMenuItem("Increase Speed");
        JMenuItem reduceSpeed = new JMenuItem("Reduce Speed");

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snakePanel.stopGame();
                snakePanel.initNewGame();
            }
        });

        increaseSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snakePanel.increaseSpeed();
            }
        });

        reduceSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snakePanel.makeNormalSpeed();
            }
        });

        mainMenu.add(exit);
        mainMenu.add(newGame);
        mainMenu.add(increaseSpeed);
        mainMenu.add(reduceSpeed);
        
        return mainMenu;
    }
}

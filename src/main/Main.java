package main;

import main.GamePanel;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel gamePanel = new GamePanel();
        window.setTitle("Melancholy Prince");

        window.add(gamePanel);
        window.pack();
        //Add window.setIcon() when design period starts.
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setGame();
        gamePanel.startGameThread();

    }
}
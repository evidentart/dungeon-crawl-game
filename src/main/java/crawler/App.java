package crawler;


import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class App {

    public static void main(String[] args) {
        new Game();
    }
}

class Game {

    private JFrame myFrame;
    private Container myCon;
    private TitleScreen titleScreen;

    public Game() {
        myFrame = new JFrame();
        myFrame.setSize(800, 600);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.getContentPane().setBackground(Color.black);
        myFrame.setLayout(null);
        myCon = myFrame.getContentPane();

        titleScreen = new TitleScreen(this);
        titleScreen.showTitleScreen();

        myFrame.setVisible(true);
        myFrame.setLocationRelativeTo(null);
    }

    public void startGame() {
        titleScreen.hideTitleScreen();
        new GameScreen(this);
    }
}
package crawler;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen {

    private Game game;
    private JFrame titleFrame;
    private Container titleCon;
    private JPanel titlePanel, startPanel;
    private JLabel titleLabel;
    private JButton startButton;

    public TitleScreen(Game game) {
        this.game = game;
        titleFrame = new JFrame();
        titleFrame.setSize(800, 600);
        titleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        titleFrame.getContentPane().setBackground(Color.black);
        titleFrame.setLayout(null);
        titleCon = titleFrame.getContentPane();

        TitleScreenHandler titleHandler = new TitleScreenHandler();

        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 600, 150);
        titlePanel.setBackground(Color.black);
        titleLabel = new JLabel("The Dungeon");
        titleLabel.setForeground(Color.red);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 90));

        startPanel = new JPanel();
        startPanel.setBounds(300, 400, 200, 100);
        startPanel.setBackground(Color.black);

        startButton = new JButton(" Start Adventure ");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.red);
        startButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        startButton.setFocusPainted(false);
        startButton.addActionListener(titleHandler);

        titlePanel.add(titleLabel);
        startPanel.add(startButton);

        titleCon.add(titlePanel);
        titleCon.add(startPanel);

        titleFrame.setVisible(true);
        titleFrame.setLocationRelativeTo(null);
    }

    public void hideTitleScreen() {
        titleFrame.setVisible(false);
    }

    private class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == startButton) {
                game.startGame();
            }
        }
    }
}

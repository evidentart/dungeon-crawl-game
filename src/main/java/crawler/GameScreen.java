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

public class GameScreen {

  private Game game;

    private JFrame myFrame;
    private Container myCon;
    private JPanel gameTextPanel, choiceButtonPanel, playerHpPanel, wpPanel, playerArmorPanel;
    private JTextArea gameTextArea;
    private JLabel hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, armorLabel, armorLabelNumber;
    private Font startText = new Font("Times New Roman", Font.PLAIN, 25);
    private JButton choice1, choice2, choice3, choice4;
    private GameChoiceHandler choiceHandler;

    private int playerHP, monsterHP, trophy, armor, enemyHP;
    private String weapon, position;

    public GameScreen(Game game) {
      this.game = game;
      // Other initialization code here
  }

    public GameScreen() {
      myFrame = new JFrame();
      myFrame.setSize(800, 600);
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.getContentPane().setBackground(Color.black);
      myFrame.setLayout(null);
      myCon = myFrame.getContentPane();

      choiceHandler = new GameChoiceHandler();

      // Game Text Panel
      gameTextPanel = new JPanel();
      gameTextPanel.setBounds(100, 100, 600, 150);
      gameTextPanel.setBackground(Color.black);

      gameTextArea = new JTextArea("Game text goes here");
      gameTextArea.setBounds(100, 100, 600, 150);
      gameTextArea.setBackground(Color.black);
      gameTextArea.setForeground(Color.white);
      gameTextArea.setFont(startText);
      gameTextArea.setLineWrap(true);
      gameTextArea.setWrapStyleWord(true);
      gameTextArea.setEditable(false);

      gameTextPanel.add(gameTextArea);
      myCon.add(gameTextPanel);

      // Choice Button Panel
      choiceButtonPanel = new JPanel();
      choiceButtonPanel.setBounds(250, 350, 300, 150);
      choiceButtonPanel.setBackground(Color.black);
      choiceButtonPanel.setLayout(new GridLayout(4, 1));

      choice1 = new JButton("Choice 1");
      choice1.setBackground(Color.black);
      choice1.setForeground(Color.white);
      choice1.setFont(startText);
      choice1.setFocusPainted(false);
      choice1.addActionListener(choiceHandler);
      choice1.setActionCommand("c1");

      choice2 = new JButton("Choice 2");
      choice2.setBackground(Color.black);
      choice2.setForeground(Color.white);
      choice2.setFont(startText);
      choice2.setFocusPainted(false);
      choice2.addActionListener(choiceHandler);
      choice2.setActionCommand("c2");

      choice3 = new JButton("Choice 3");
      choice3.setBackground(Color.black);
      choice3.setForeground(Color.white);
      choice3.setFont(startText);
      choice3.setFocusPainted(false);
      choice3.addActionListener(choiceHandler);
      choice3.setActionCommand("c3");

      choice4 = new JButton("Choice 4");
      choice4.setBackground(Color.black);
      choice4.setForeground(Color.white);
      choice4.setFont(startText);
      choice4.setFocusPainted(false);
      choice4.addActionListener(choiceHandler);
      choice4.setActionCommand("c4");

      choiceButtonPanel.add(choice1);
      choiceButtonPanel.add(choice2);
      choiceButtonPanel.add(choice3);
      choiceButtonPanel.add(choice4);

      myCon.add(choiceButtonPanel);

      // Player HP Panel
      playerHpPanel = new JPanel();
      playerHpPanel.setBounds(100, 15, 150, 50);
      playerHpPanel.setBackground(Color.black);

      hpLabel = new JLabel("HP:");
      hpLabel.setForeground(Color.white);
      hpLabel.setFont(startText);

      hpLabelNumber = new JLabel();
      hpLabelNumber.setForeground(Color.white);
      hpLabelNumber.setFont(startText);

      playerHpPanel.add(hpLabel);
      playerHpPanel.add(hpLabelNumber);
      myCon.add(playerHpPanel);

      // Weapon Panel
      wpPanel = new JPanel();
      wpPanel.setBounds(300, 15, 200, 50);
      wpPanel.setBackground(Color.black);
      wpPanel.setLayout(new GridLayout(1, 1));
      myCon.add(wpPanel);

      weaponLabel = new JLabel("Weapon:");
      weaponLabel.setForeground(Color.white);
      weaponLabel.setFont(startText);

      weaponLabelName = new JLabel();
      weaponLabelName.setForeground(Color.white);
      weaponLabelName.setFont(startText);

      wpPanel.add(weaponLabel);
      wpPanel.add(weaponLabelName);
      myCon.add(wpPanel);

      // Player Armor Panel
      playerArmorPanel = new JPanel();
      playerArmorPanel.setBounds(550, 15, 200, 50);
      playerArmorPanel.setBackground(Color.black);

      armorLabel = new JLabel("Armor:");
      armorLabel.setForeground(Color.white);
      armorLabel.setFont(startText);

      armorLabelNumber = new JLabel();
      armorLabelNumber.setForeground(Color.white);
      armorLabelNumber.setFont(startText);

      playerArmorPanel.add(armorLabel);
      playerArmorPanel.add(armorLabelNumber);
      myCon.add(playerArmorPanel);

      hpLabel = new JLabel();
      hpLabel.setFont(startText);
      hpLabel.setForeground(Color.red);
      wpPanel.add(hpLabel);

      hpLabelNumber = new JLabel();
      hpLabelNumber.setFont(startText);
      hpLabelNumber.setForeground(Color.red);
      wpPanel.add(hpLabelNumber);

      weaponLabel = new JLabel();
      weaponLabel.setFont(startText);
      weaponLabel.setForeground(Color.red);
      wpPanel.add(weaponLabel);

      weaponLabelName = new JLabel();
      weaponLabelName.setFont(startText);
      weaponLabelName.setForeground(Color.red);
      wpPanel.add(weaponLabelName);


        playerSetup();
        townEntrance();
        showGameScreen();
    }

    private void playerSetup() {
        playerHP = 100;
        monsterHP = 50;
        armor = 0;
        weapon = "Sword";
        weaponLabelName.setText("Weapon:  " + weapon);
        hpLabelNumber.setText("Hp:  " + playerHP);
        armorLabelNumber.setText("Armor:  " + armor);
    }

    private void townEntrance() {
        position = "townEntrance";
        gameTextArea.setText("~You are the goblin slayer who makes his living"
                + " by slaying monsters. You recently heard about trouble in a village\n"
                + "called Waterfall and decided to investigate~\n"
                + "\nGoblin Slayer: This must be the village...I need to talk to\nsomeone about "
                + "the contract.");

        choice1.setText("Talk the guard");
        choice2.setText("Attack the guard");
        choice3.setText("Leave the village");
        choice4.setText("");
    }

    private void acceptContract() {
        position = "acceptContract";
        gameTextArea.setText("Guard: Here take a look...\n\n"
                + "~Some evil monster taken hold of our fields.\n"
                + " Anyone who is willing to slay the beast will be rewarded\n"
                + " 300 golds will be offered if you bring the trophy.~");

        choice1.setText("Accept");
        choice2.setText("Decline");
        choice3.setText("");
        choice4.setText("");
    }

    private void acceptChoice() {
        position = "acceptChoice";
        gameTextArea.setText("Guard: Be careful, the beast already claimed many souls...\n"
                + "Here take this\n"
                + "~ You gained gambeson.\n"
                + "Armor increased by 25");
        armor = armor + 25;

        armorLabelNumber.setText("Armor: " + armor);

        choice1.setText("Leave the village");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void talkGuard() {
      position = "talkGuard";
      gameTextArea.setText("Guard: Look at what we got here, a goblin slayer...\n"
          + "Are you here for the contract ?");
      
      if (armor == 25) {
        gameTextArea.setText("Are you still here ?");
        choice1.setText("Nevermind");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
      }
      else {
      
      
      choice1.setText("Yes, what do you need ?");
      choice2.setText("Forget it, I'll take my leave");
      choice3.setText("");
      choice4.setText("");
      }
    }

    public void attackGuard() {
      position = "attackGuard";
      gameTextArea.setText("Guard: Big mistake!");
      playerHP = playerHP - 10;
      
      hpLabelNumber.setText("HP:  " + playerHP);
      
      
      if(playerHP <= 0) {
        gameTextArea.setText("You are dead !\n\n <GAME OVER>");
        
        
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
      }else {
      choice1.setText(">");
      choice2.setText("");
      choice3.setText("");
      choice4.setText("");
      }
      
    }


    public void crossRoad() {
      position = "crossRoad";
      gameTextArea.setText("You are at crossroad.\n\n~Consider exploring the area before venturing"
          + " off...\nOnce you claim the trophy,go back to the castle and talk to guard...~");
      choice1.setText("Altar of Replenish");
      choice2.setText("Forbidden Forest");
      choice3.setText("Castle Entrance");
      choice4.setText("Dungeon Entrance");
    }
    public void north() {
      position = "north";
      gameTextArea.setText("There is a river. Drink and replenish 20 HP");
      
      
      playerHP = playerHP + 10;
      hpLabelNumber.setText("Hp:  " + playerHP);
      choice1.setText("Back to town");
      choice2.setText("");
      choice3.setText("");
      choice4.setText("");
    }
    public void forest() {
      position = "forest";
      gameTextArea.setText("While walking in the forest, you found a shady mercant \noffering free items,"
          + " however you can only pick one of them.");
      choice1.setText("Long Sword");
      choice2.setText("Fire Wand");
      choice3.setText("Back to town");
      choice4.setText("");
    }
    
    
    public void west() {
      position = "west";
      
      gameTextArea.setText("You encounter a monster!");   
      choice1.setText("Fight");
      choice2.setText("Escape");
      choice3.setText("");
      choice4.setText("");
      
    }
    
    public void fight() {
      position = "fight";
      gameTextArea.setText("Rare Goblin: " + monsterHP + " ~ Hp"+"\n\nMake your next move\nYou can leave"
          + " and try another way to slay the creature...");
      choice1.setText("Attack");
      choice2.setText("Escape");
      choice3.setText("");
      choice4.setText("");
    }
    
    
    public void playerAttack() {
      position = "playerAttack";
        
        int playerDamage = 0;
        
        if(weapon.equals("Sword")) {
          
          playerDamage = new java.util.Random().nextInt(15);
        
        }
        else if(weapon.equals("Long Sword")) {
          
          playerDamage = new java.util.Random().nextInt(20);
        }
        else if(weapon.equals("Fire Wand")) {
          playerDamage = new java.util.Random().nextInt(25);
        }
          
        gameTextArea.setText("You attacked the goblin and gave " + playerDamage + " damage!");
        
        monsterHP = monsterHP - playerDamage;
        
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void monsterAttack() {
      position = "monsterAttack";
      
      int monsterDamage = 0;
      
      monsterDamage = new java.util.Random().nextInt(25);
      gameTextArea.setText("The goblin attacked you and gave " + monsterDamage + " damage!");
      
      
      if (armor > 0) {
        
        armor = armor - monsterDamage;
        hpLabelNumber.setText("Hp:  " + playerHP);
        armorLabelNumber.setText("Armor:  " + armor);
        
      }
      else {
        
        
        playerHP = playerHP - monsterDamage;
        armor = 0;
        hpLabelNumber.setText("Hp:  " + playerHP);
        armorLabelNumber.setText("Armor:  " + armor);
      }
      
      choice1.setText(">");
      choice2.setText("");
      choice3.setText("");
      choice4.setText("");
    }
    
    public void win() {
      position = "win";
      gameTextArea.setText("You defeated the goblin and collected the trophy,\n"
          + "however you can hear strange things deep in the darkness...");
      
      trophy = 1;
      
      choice1.setText("Back to town");
      choice2.setText("Chained Door");
      choice3.setText("");
      choice4.setText("");
    }
    
    public void lose() {
      position = "lose";
      gameTextArea.setText("You are dead !\n\n <GAME OVER>");
      
      
      choice1.setVisible(false);
      choice2.setVisible(false);
      choice3.setVisible(false);
      choice4.setVisible(false);
    }
    
 
    // ... (other methods)

    private void showGameScreen() {
        myFrame.setVisible(true);
        myFrame.setLocationRelativeTo(null);
    }

    private class GameChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            switch (position) {
                case "townEntrance":
                    switch (yourChoice) {
                        case "c1":
                            if (trophy == 1) {
                                ending();
                            } else {
                                talkGuard();
                            }
                            break;
                        case "c2":
                            attackGuard();
                            break;
                        case "c3":
                            crossRoad();
                            break;
                    }
                    break;

                case "talkGuard":
                    switch (yourChoice) {
                        case "c1":
                            if (armor == 25) {
                                townEntrance();
                                break;
                            } else {
                                acceptContract();
                                break;
                            }

                        case "c2":
                            townEntrance();
                            break;
                    }
                    break;

                case "acceptContract":
                    switch (yourChoice) {
                        case "c1":
                            acceptChoice();
                            break;
                        case "c2":
                            townEntrance();
                            break;
                    }
                    break;

                // ... (other switch cases for different game states)

            }
        }
    }

    // ... (other methods)

    private void ending() {
        position = "ending";

        gameTextArea.setText("Guard: Nice job witcher, go ahead\nGood luck!");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
}

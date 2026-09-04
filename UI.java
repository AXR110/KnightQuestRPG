package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

import system.Game.ChoiceHandler;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;

public class UI {

    //Create the window as well as all the panels, labels, buttons, etc.
    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, titleOutlineLabel, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    //Font initialization
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 76);
    Font startFont = new Font("Times New Roman", Font.PLAIN, 24);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);

    public void createUI(ChoiceHandler cHandler) {

        //Window initialization stuff with dimensions
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        //Title Screen details
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 200, 600, 500);
        titleNamePanel.setOpaque(false);
        //titleNamePanel.setBackground(Color.black);
        //Title Text details
        titleNameLabel = new JLabel(" KNIGHT QUEST ");
        //custom gold colour
        Color goldRGB = new Color(212, 175, 55);
        titleNameLabel.setOpaque(true);
        titleNameLabel.setBackground(Color.black);
        titleNameLabel.setForeground(goldRGB);
        titleNameLabel.setBorder(BorderFactory.createLineBorder(goldRGB, 5));
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        //Image background
        //Try catch just in case file name is messed up
        try {
            //this should read for the image file, size it according to the window, and set the background
            ImageIcon originalIcon = new ImageIcon(ImageIO.read(new File("KnightQuest/src/KnightQuestBackground.jpg")));
            Image scaledImage = originalIcon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel backgroundImage = new JLabel(scaledIcon);
            window.setContentPane(backgroundImage);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Start button stuff (most buttons will follow this same format: it is commented for later reference)
        startButtonPanel = new JPanel(); // create new panel
        startButtonPanel.setBounds(200, 320, 400, 100); // initialize dimensions
        startButtonPanel.setOpaque(false);
        //startButtonPanel.setBackground(Color.black); // set background color of the panel

        startButton = new JButton("  BEGIN YOUR ADVENTURE...  "); // create new button + what will be displayed on the button
        startButton.setOpaque(true);
        startButton.setBackground(Color.black);
        startButton.setForeground(goldRGB);
        startButton.setBorder(BorderFactory.createLineBorder(goldRGB, 4));
        startButton.setFont(startFont); // set the font type
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startButtonPanel.add(startButton);

        //Add title text and start button to the window
        window.add(titleNamePanel);
        window.add(startButtonPanel);

        //General game screen text panel
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        mainTextPanel.setBorder(BorderFactory.createLineBorder(Color.white, 5));
        window.add(mainTextPanel);

        //Text for the game screen
        mainTextArea = new JTextArea("This is the main text area");
        mainTextArea.setBounds(100, 100, 590, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        //Button panel for FOUR buttons
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setOpaque(true);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        window.add(choiceButtonPanel);

        //button1, added to choice button panel
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setBorder(BorderFactory.createLineBorder(Color.white));
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        //button2, added to choice button panel
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setBorder(BorderFactory.createLineBorder(Color.white));
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        //button3, added to choice button panel
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setBorder(BorderFactory.createLineBorder(Color.white));
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        //button4, added to choice button panel
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setBorder(BorderFactory.createLineBorder(Color.white));
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        //Player status area (hp, weapon)
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setBorder(BorderFactory.createLineBorder(Color.white, 5));
        playerPanel.setLayout(new GridLayout(1,4));
        window.add(playerPanel);

        //Label for HP which will go on the player panel
        hpLabel = new JLabel("HP: ", SwingConstants.TRAILING);
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        //Label for HP Number which will go on the player panel
        hpNumberLabel = new JLabel("", SwingConstants.LEADING);
        hpNumberLabel.setForeground(Color.white);
        hpNumberLabel.setFont(normalFont);
        playerPanel.add(hpNumberLabel);
        //Label for Weapon which will go on the player panel
        weaponLabel = new JLabel("Weapon: ", SwingConstants.TRAILING);
        weaponLabel.setForeground(Color.white);
        weaponLabel.setFont(normalFont);
        playerPanel.add(weaponLabel);
        //Label for Weapon Name which will go on the player panel
        weaponNameLabel = new JLabel("", SwingConstants.LEADING);
        weaponNameLabel.setForeground(Color.white);
        weaponNameLabel.setFont(normalFont);
        playerPanel.add(weaponNameLabel);

        window.setVisible(true);
    }
}

/*
* File: MainWindow.java
* Author: Nagy József
* Copyright: 2021, Nagy József 
* Date: 2021-09-11
* Licenc: MIT
* Refaktor: Miklós Rajmund
* Github: https://github.com/ItsChippie 
*/
package views;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
    public JButton startBtn;
    public JButton stopBtn;
    public JButton nextBtn;
    public JPanel tablePanel;
    public JButton flop1Btn;
    public JButton flop2Btn;
    public JButton flop3Btn;
    public JPanel handPanel;
    public JButton humanCard1Btn;
    public JButton humanCard2Btn;
    public JPanel buttonPanel;
    public JButton turnButton;
    public JButton riverButton;

    public void initComponents() {
        this.startButton = new JButton("Start");
        this.stopButton = new JButton("Stop");
        this.nextButton = new JButton("Következő");
        this.humanCard1Button = new JButton();
        this.humanCard2Button = new JButton();
        this.computerCard1Button = new JButton();
        this.computerCard2Button = new JButton();
        this.flop1Button = new JButton();
        this.flop2Button = new JButton();
        this.flop3Button = new JButton();
        this.turnButton = new JButton();
        this.riverButton = new JButton();
        this.buttonPanel = new JPanel();
        this.tablePanel = new JPanel();
        this.humanPanel = new JPanel();
    }

    public MainWindow() {
        initializeComponents();
        configureLayout();
        setupWindowProperties();
    }
    
    private void initializeComponents() {
        setupTablePanel();
        setupHandPanel();
        setupButtonPanel();
    }
    
    private void setupTablePanel() {
        tablePanel.setSize(100, 100);
        tablePanel.setBackground(Color.LIGHT_GRAY);
        setupFlopButtons();
        tablePanel.add(turnButton);
        tablePanel.add(riverButton);
        turnButton.setVisible(false);
        riverButton.setVisible(false);
    }
    
    private void setupFlopButtons() {
        tablePanel.add(flop1Btn);
        tablePanel.add(flop2Btn);
        tablePanel.add(flop3Btn);
        flop1Btn.setVisible(false);
        flop2Btn.setVisible(false);
        flop3Btn.setVisible(false);
    }
    
    private void setupHandPanel() {
        handPanel.add(humanCard1Btn);
        handPanel.add(humanCard2Btn);
    }
    
    private void setupButtonPanel() {
        buttonPanel.add(startBtn);
        buttonPanel.add(nextBtn);
        buttonPanel.add(stopBtn);
    }
    
    private void configureLayout() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(buttonPanel);
        add(tablePanel);
        add(handPanel);
    }
    
    private void setupWindowProperties() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
    }    
}

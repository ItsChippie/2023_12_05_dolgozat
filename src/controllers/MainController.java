/*
* File: MainController.java
* Author: Nagy József
* Copyright: 2021, Nagy József 
* Date: 2021-09-11
* Licenc: MIT
* Refaktor: Miklós Rajmund
* Github: https://github.com/ItsChippie 
*/

package controllers;

import java.util.Random;
import views.MainWindow;

import java.util.Random;

public class MainController {

    enum Round {
        PREFLOP,
        FLOP,
        TURN,
        RIVER,
        SHOW
    }

    private final MainWindow mainWindow;
    private final String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "D", "K", "A"};
    private Round round = Round.PREFLOP;

    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.initEvent();
    }

    private int getRandomCardIndex() {
        Random random = new Random();
        return random.nextInt(cards.length);
    }

    private void initEvent() {
        this.mainWindow.startBtn.addActionListener(event -> handleStartButton());
        this.mainWindow.stopBtn.addActionListener(event -> handleStopButton());
        this.mainWindow.nextBtn.addActionListener(event -> handleNextButton());
    }

    private void handleStartButton() {
        int humanCard1 = getRandomCardIndex();
        int humanCard2 = getRandomCardIndex();

        String humanCard1Str = cards[hcard1];
        String humanCard2Str = cards[hcard2];

        this.mainWindow.humanCard1Btn.setText(humanCard1Str);
        this.mainWindow.humanCard2Btn.setText(humanCard2Str);

        System.out.printf("%d %d\n", hcard1, hcard2);
    }

    private void handleStopButton() {
        System.out.println("Állj");
    }

    private void handleNextButton() {
        switch (round) {
            case PREFLOP:
                handlePreflop();
                break;
            case FLOP:
                handleFlop();
                break;
            case TURN:
                handleTurn();
                break;
            case RIVER:
                handleRiver();
                break;
        }
    }

    private void handlePreflop() {
        int flop1 = getRandomCardIndex();
        int flop2 = getRandomCardIndex();
        int flop3 = getRandomCardIndex();

        String flop1Str = cards[flop1];
        String flop2Str = cards[flop2];
        String flop3Str = cards[flop3];

        this.mainWindow.flop1Btn.setText("♦" + flop1Str);
        this.mainWindow.flop2Btn.setText(flop2Str);
        this.mainWindow.flop3Btn.setText(flop3Str);

        this.mainWindow.flop1Btn.setVisible(true);
        this.mainWindow.flop2Btn.setVisible(true);
        this.mainWindow.flop3Btn.setVisible(true);

        this.round = Round.FLOP;
    }

    private void handleFlop() {
        int turn = getRandomCardIndex();
        this.mainWindow.turnButton.setText(cards[turn]);
        this.mainWindow.turnButton.setVisible(true);
        this.round = Round.TURN;
    }

    private void handleTurn() {
        int river = getRandomCardIndex();
        this.mainWindow.riverButton.setText(cards[river]);
        this.mainWindow.riverButton.setVisible(true);
        this.round = Round.RIVER;
    }

    private void handleRiver() {
    }
}
package game;

import java.util.Random;


public class GameBot {
    private String name;
    private PlayerBot playerBot;

    public GameBot(String name) {
        this.name = name;
        this.playerBot = new PlayerBot();
    }

    public String getName() {
        return name;
    }


    public Bet makeBet(int maxDiceValue, int maxBet) {
        return playerBot.makeBet();
    }

    @Override
    public String toString() {
        return "GameBot: " + name;
    }
}
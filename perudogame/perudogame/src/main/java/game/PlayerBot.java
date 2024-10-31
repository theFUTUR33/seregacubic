package game;

import java.util.Random;

public class PlayerBot {
    private Random random;

    public PlayerBot() {
        random = new Random();
    }

    public Bet makeBet() {

        int maxDiceCount = 20;
        int maxBetValue = 6;

        int diceCount = random.nextInt(maxDiceCount) + 1;


        int betValue = random.nextInt(maxBetValue) + 1;


        boolean isLiar = random.nextDouble() < 0.4;


        if (isLiar) {
            System.out.println("Бот делает ложную ставку: " + diceCount + " кубиков с значением " + betValue + " (liar)");
        } else {
            System.out.println("Бот делает ставку: " + diceCount + " кубиков с значением " + betValue);
        }


        return new Bet(diceCount, betValue, isLiar);
    }
}
package game;

import java.util.ArrayList;
import java.util.List;

public class CubeGame {
    private int firstCubeDots;
    private int secondCubeDots;
    private int thirdCubeDots;
    private int fourthCubeDots;
    private int fifthCubeDots;

    private static int turnCounter = 1;
    private List<Integer> bets;
    private int currentPlayerIndex;

    public CubeGame() {
        this.bets = new ArrayList<>();
        this.currentPlayerIndex = 0;
    }

    public int getFirstCubeDots() {
        return firstCubeDots;
    }

    public int getSecondCubeDots() {
        return secondCubeDots;
    }

    public int getThirdCubeDots() {
        return thirdCubeDots;
    }

    public int getFourthCubeDots() {
        return fourthCubeDots;
    }

    public int getFifthCubeDots() {
        return fifthCubeDots;
    }

    public static int getTurnCounter() {
        return turnCounter;
    }

    private int generateNumberOfDots() {
        int min = 1;
        int max = 6;
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public void getCubeDots() {
        if (turnCounter == 5) {
            showResult();
        } else {
            firstCubeDots = generateNumberOfDots();
            secondCubeDots = generateNumberOfDots();
            thirdCubeDots = generateNumberOfDots();
            fourthCubeDots = generateNumberOfDots();
            fifthCubeDots = generateNumberOfDots();
            turnCounter++;
        }
    }

    private void showResult() {
        System.out.println("Результаты броска: " + firstCubeDots + ", " + secondCubeDots + ", " +
                thirdCubeDots + ", " + fourthCubeDots + ", " + fifthCubeDots);
    }

    public void displayCurrentState() {
        System.out.println("Текущие ставки: " + bets);
        System.out.println("Текущий игрок: " + currentPlayerIndex);
        System.out.println("Общее количество бросков: " + turnCounter);
        System.out.println("Результаты кубиков: " + firstCubeDots + ", " + secondCubeDots + ", " +
                thirdCubeDots + ", " + fourthCubeDots + ", " + fifthCubeDots);
    }




    public boolean checkBet(int quantity, int value) {

        if (quantity > 0 && quantity <= turnCounter * 5) {
            bets.add(quantity);
            return true;
        }
        return false;
    }


    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % bets.size();
    }


    public boolean isGameOver() {
        return turnCounter > 5;
    }
}

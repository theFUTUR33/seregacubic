package game;

import java.util.Scanner;

public class PlayerTurn {
    private CubeGame cubeGame;
    private String playerName;
    private Scanner scanner;

    public PlayerTurn(CubeGame cubeGame, String playerName) {
        this.cubeGame = cubeGame;
        this.playerName = playerName;
        this.scanner = new Scanner(System.in);
    }

    public void takeTurn() {
        System.out.println("Ход игрока: " + playerName);

        cubeGame.displayCurrentState();

        int quantity = getQuantityFromPlayer();
        int value = getValueFromPlayer();

        boolean isValid = cubeGame.checkBet(quantity, value);
        if (isValid) {
            System.out.println(playerName + " сделал ставку: " + quantity + " кубиков с значением " + value);
            cubeGame.nextPlayer();
        } else {
            System.out.println("Ставка недействительна. Попробуйте снова.");
            takeTurn();
        }
    }

    private int getQuantityFromPlayer() {
        int quantity = 0;
        while (true) {
            System.out.print("Введите количество кубиков, на которое вы ставите (макс. 20): ");
            String input = scanner.nextLine();
            try {
                quantity = Integer.parseInt(input);
                if (quantity > 0 && quantity <= 20) {
                    break;
                } else {
                    System.out.println("Неверное количество. Пожалуйста, введите число от 1 до 20.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
            }
        }
        return quantity;
    }

    private int getValueFromPlayer() {
        int value = 0;
        while (true) {
            System.out.print("Введите значение кубика (1-6): ");
            String input = scanner.nextLine();
            try {
                value = Integer.parseInt(input);
                if (value >= 1 && value <= 6) {
                    break;
                } else {
                    System.out.println("Неверное значение. Пожалуйста, введите число от 1 до 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
            }
        }
        return value;
    }
}
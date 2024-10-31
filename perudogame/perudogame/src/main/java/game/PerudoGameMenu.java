package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PerudoGameMenu {
    private static final String RULES_FILE = "C:\\Users\\admin\\IdeaProjects\\perudogame-master-main\\perudogame-master-main\\perudogame-master\\src\\main\\java\\game\\rule.txt";
    private Scanner scanner;

    public PerudoGameMenu() {
        scanner = new Scanner(System.in);
    }

    private void showMenu() {
        boolean validChoice = false;

        while (!validChoice) {
            System.out.println("1. Начать игру");
            System.out.println("2. Правила игры");
            System.out.println("3. Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    startGame();
                    validChoice = true;
                    break;
                case 2:
                    showRules();
                    startGame();
                    validChoice = true;
                    break;
                case 3:
                    System.out.println("До свидания!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");

                    break;
            }
        }
    }

    private void startGame() {
        GameInterface gameInterface = new GameInterface();
        gameInterface.startGame();
    }

    private static void showRules() {
        try (BufferedReader reader = new BufferedReader(new FileReader(RULES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла правил: " + e.getMessage());
        }


    }
    public static void main(String[] args) {
        PerudoGameMenu app = new PerudoGameMenu();
        app.showMenu(); // Запуск меню
    }
}


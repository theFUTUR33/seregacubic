package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameInterface {
    private static final String NAMES_FILE = "C:\\Users\\admin\\IdeaProjects\\perudogame-master-main\\perudogame-master-main\\perudogame-master\\src\\main\\java\\game\\nickname.txt";
    private static final int NUM_AI_PLAYERS = 3;
    private CubeGame cubeGame;
    private Scanner scanner;

    public GameInterface() {
        this.cubeGame = new CubeGame();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.print("Введите имя игрока (или нажмите Enter для генерации): ");
        String playerName = scanner.nextLine();

        if (playerName.isEmpty()) {
            playerName = generateRandomName();
        }

        System.out.println("Добро пожаловать, " + playerName + "!");
        cubeGame = new CubeGame();
        showTurn();

        List<Player> aiPlayers = createAIPlayers();


        PlayerTurn playerTurn = new PlayerTurn(cubeGame, playerName);
        playerTurn.takeTurn();
    }

    private static String generateRandomName() {
        List<String> names = loadNamesFromFile();
        Random random = new Random();
        return names.get(random.nextInt(names.size()));
    }

    List<Player> createAIPlayers() {
        List<Player> aiPlayers = new ArrayList<>();
        List<String> names = loadNamesFromFile();
        Random random = new Random();

        for (int i = 0; i < NUM_AI_PLAYERS; i++) {
            int randomIndex = random.nextInt(names.size());
            String aiName = names.get(randomIndex);
            Player aiPlayer = new Player(aiName);
            aiPlayers.add(aiPlayer);
            System.out.println("Создан игрок-робот: " + aiPlayer.getName());
        }

        return aiPlayers;
    }
    private static List<String> loadNamesFromFile() {
        List<String> names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(NAMES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла имен: " + e.getMessage());
        }
        return names;



    }

    private void showTurn() {
        cubeGame.getCubeDots();
        System.out.println("Ваши кубики:");
        generateCubes(cubeGame.getFirstCubeDots());
        generateCubes(cubeGame.getSecondCubeDots());
        generateCubes(cubeGame.getThirdCubeDots());
        generateCubes(cubeGame.getFourthCubeDots());
        generateCubes(cubeGame.getFifthCubeDots());

    }

    private void checkTurnResult(boolean choice) {
    }

    private void generateCubes(int cubeDots) {
        switch (cubeDots) {
            case 1 -> generateOneDot();
            case 2 -> generateTwoDots();
            case 3 -> generateThreeDots();
            case 4 -> generateFourDots();
            case 5 -> generateFiveDots();
            case 6 -> generateSixDots();
        }
    }

    private void generateSixDots() {
        System.out.println("Cube:");
        System.out.println("● ● ●");
        System.out.println("● ● ●");
    }

    private void generateFiveDots() {
        System.out.println("Cube:");
        System.out.println("● ●");
        System.out.println(" ●");
        System.out.println("● ●");
    }

    private void generateFourDots() {
        System.out.println("Cube:");
        System.out.println("● ●");
        System.out.println("● ●");
    }

    private void generateThreeDots() {
        System.out.println("Cube:");
        System.out.println("● ● ●");
    }

    private void generateTwoDots() {
        System.out.println("Cube:");
        System.out.println("● ●");
    }

    private void generateOneDot() {
        System.out.println("Cube:");
        System.out.println("●");
    }

    private String getScannerData(String message) {
        System.out.println(message);
        return new Scanner(System.in).nextLine();
    }
}

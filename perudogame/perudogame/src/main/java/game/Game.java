package game;

import java.util.List;

public class Game {
    private List<Player> players;
    private int currentPlayerIndex;
    private CubeGame cubeGame;

    public Game(List<Player> players) {
        this.players = players;
        this.currentPlayerIndex = 0;
        this.cubeGame = new CubeGame();
    }

    public void startGame() {
        while (!cubeGame.isGameOver()) {
            Player currentPlayer = players.get(currentPlayerIndex);
            PlayerTurn playerTurn = new PlayerTurn(cubeGame, currentPlayer.getName());
            playerTurn.takeTurn();
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

        System.out.println("Игра окончена!");
    }
}
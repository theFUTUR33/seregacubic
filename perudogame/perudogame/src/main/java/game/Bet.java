package game;

public class Bet {
    private int diceCount;
    private int value;
    private boolean isLiar;

    public Bet(int diceCount, int value, boolean isLiar) {
        this.diceCount = diceCount;
        this.value = value;
        this.isLiar = isLiar;
    }

    public int getDiceCount() {
        return diceCount;
    }

    public int getValue() {
        return value;
    }

    public boolean isLiar() {
        return isLiar;
    }
}
package SnakeAndLadderGame.src.entity;

public class TurnContext {
    private boolean skipTurn;
    private int consecutiveSixes;
    private int totalMoveCount;

    public TurnContext() {
        this.skipTurn = false;
        this.consecutiveSixes = 0;
        this.totalMoveCount = 0;
    }

    public void incrementSixes() {
        this.consecutiveSixes++;
    }

    public int getConsecutiveSixes() {
        return this.consecutiveSixes;
    }

    public void resetSixes() {
        this.consecutiveSixes = 0;
    }

    public void addMove(int amount) {
        this.totalMoveCount += amount;
    }

    public int getTotalMoveCount() {
        return this.totalMoveCount;
    }

    public void triggerSkip() {
        this.skipTurn = true;
        this.totalMoveCount = 0;
    }

    public boolean isSkipTurn() {
        return !this.skipTurn;
    }
}
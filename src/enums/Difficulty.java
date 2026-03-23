package SnakeAndLadderGame.src.enums;

public enum Difficulty {
    HARD,
    EASY;

    public static Difficulty getDifficulty(String difficulty) {
        return Difficulty.valueOf(difficulty.toUpperCase());
    }
}

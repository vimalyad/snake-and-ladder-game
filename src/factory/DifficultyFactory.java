package SnakeAndLadderGame.src.factory;

import SnakeAndLadderGame.src.strategy.DifficultyStrategy;
import SnakeAndLadderGame.src.strategy.EasyDifficultyStrategy;
import SnakeAndLadderGame.src.strategy.HardDifficultyStrategy;

import java.util.HashMap;
import java.util.Map;

public class DifficultyFactory {

    private DifficultyFactory() {}

    private static final Map<String, DifficultyStrategy> strategies = new HashMap<>();

    static {
        strategies.put("easy", new EasyDifficultyStrategy());
        strategies.put("hard", new HardDifficultyStrategy());
    }

    public static DifficultyStrategy getStrategy(String difficulty) {
        DifficultyStrategy strategy = strategies.get(difficulty.toLowerCase());
        if (strategy == null) throw new IllegalArgumentException("Invalid difficulty level: " + difficulty);
        return strategy;
    }
}
package SnakeAndLadderGame.src.strategy;

import SnakeAndLadderGame.src.entity.TurnContext;

public class HardDifficultyStrategy implements DifficultyStrategy {
    @Override
    public void handleThreeSixes(TurnContext context) {
        System.out.println("3 sixes! Chance skipped.");
        context.triggerSkip();
    }
}
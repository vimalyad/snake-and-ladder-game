package SnakeAndLadderGame.src.strategy;

import SnakeAndLadderGame.src.entity.TurnContext;

public class EasyDifficultyStrategy implements DifficultyStrategy {
    @Override
    public void handleThreeSixes(TurnContext context) {
        System.out.println("3 sixes! Counter reset, roll again.");
        context.resetSixes();
    }
}
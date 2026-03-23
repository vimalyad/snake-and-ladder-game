package SnakeAndLadderGame.src.strategy;

import SnakeAndLadderGame.src.entity.TurnContext;

public interface DifficultyStrategy {
    void handleThreeSixes(TurnContext context);
}
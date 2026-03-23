package SnakeAndLadderGame.src.factory;

import SnakeAndLadderGame.src.entity.Dice;

public class DiceFactory {

    private DiceFactory() {
    }

    public static Dice createDice(int faces) {
        return new Dice(faces);
    }
}

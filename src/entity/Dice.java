package SnakeAndLadderGame.src.entity;

import java.util.Random;

public class Dice {

    private final int sides;
    private final Random rand;

    public Dice(int sides) {
        this.sides = sides;
        this.rand = new Random();
    }

    public int roll() {
        return this.rand.nextInt(this.sides) + 1;
    }
}

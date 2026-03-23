package SnakeAndLadderGame.src.entity;

public class Ladder extends BoardEntity {
    public Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    public int apply() {
        System.out.println("🪜 Climbed a ladder to " + this.getEnd());
        return this.getEnd();
    }
}
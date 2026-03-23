package SnakeAndLadderGame.src.entity;

public class Ladder extends BoardEntity {

    public Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    public int apply() {
        System.out.println("Player got ladder.");
        return this.getEnd();
    }
}

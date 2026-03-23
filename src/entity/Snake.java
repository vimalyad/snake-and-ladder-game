package SnakeAndLadderGame.src.entity;

public class Snake extends BoardEntity {
    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public int apply() {
        System.out.println("🐍 Snake bite. Sliding down to " + this.getEnd());
        return this.getEnd();
    }
}
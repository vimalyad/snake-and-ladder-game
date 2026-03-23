package SnakeAndLadderGame.src.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Board {
    private final int size;
    private final Map<Integer, BoardEntity> boardEntityMap;

    public Board(int size) {
        this.size = size;
        this.boardEntityMap = new HashMap<>();
    }

    public void addEntity(int position, BoardEntity entity) {
        if (position < 0 || position > totalCells()) throw new IllegalArgumentException("Position out of range");
        if (boardEntityMap.containsKey(position))
            throw new IllegalArgumentException("Entity already exists at position " + position);
        this.boardEntityMap.put(position, entity);
    }

    public int totalCells() {
        return this.size * this.size;
    }

    public Optional<BoardEntity> getEntity(int position) {
        return Optional.ofNullable(this.boardEntityMap.get(position));
    }
}
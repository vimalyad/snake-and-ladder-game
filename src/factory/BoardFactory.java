package SnakeAndLadderGame.src.factory;

import SnakeAndLadderGame.src.entity.Board;
import SnakeAndLadderGame.src.entity.Ladder;
import SnakeAndLadderGame.src.entity.Snake;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BoardFactory {

    private BoardFactory() {
    }

    public static Board createBoard(int n) {
        Board board = new Board(n);
        Random random = new Random();
        int maxCells = board.totalCells();
        Set<Integer> occupiedCells = new HashSet<>();

        occupiedCells.add(1);
        occupiedCells.add(maxCells);

        for (int i = 0; i < n; i++) {
            int start, end;
            do {
                int startRow = random.nextInt(n - 1);
                int endRow = startRow + 1 + random.nextInt(n - 1 - startRow);

                start = (startRow * n) + random.nextInt(n) + 1;
                end = (endRow * n) + random.nextInt(n) + 1;

            } while (occupiedCells.contains(start) || occupiedCells.contains(end));

            board.addEntity(start, new Ladder(start, end));
            occupiedCells.add(start);
            occupiedCells.add(end);
        }

        for (int i = 0; i < n; i++) {
            int start, end;
            do {
                int startRow = random.nextInt(n - 1) + 1;

                int endRow = random.nextInt(startRow);

                start = (startRow * n) + random.nextInt(n) + 1;
                end = (endRow * n) + random.nextInt(n) + 1;

            } while (occupiedCells.contains(start) || occupiedCells.contains(end));

            board.addEntity(start, new Snake(start, end));
            occupiedCells.add(start);
            occupiedCells.add(end);
        }

        return board;
    }
}
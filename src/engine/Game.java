package SnakeAndLadderGame.src.engine;

import SnakeAndLadderGame.src.entity.*;
import SnakeAndLadderGame.src.strategy.DifficultyStrategy;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class Game {
    private final Board board;
    private final DifficultyStrategy strategy;
    private final Queue<Player> playerQueue;
    private final Dice dice;

    public Game(Board board, DifficultyStrategy strategy, List<Player> players, Dice dice) {
        this.board = board;
        this.strategy = strategy;
        this.playerQueue = new LinkedList<>(players);
        this.dice = dice;
    }

    public void play() {
        System.out.println("--- GAME START ---");
        int rank = 1;
        int maxCells = board.totalCells();

        while (playerQueue.size() > 1) {
            Player currentPlayer = playerQueue.poll();
            System.out.println("\n" + currentPlayer.getName() + "'s turn (Position: " + currentPlayer.getCurrentPosition() + ")");

            TurnContext context = new TurnContext();

            while (context.isSkipTurn()) {
                int roll = dice.roll();
                System.out.println("Rolled a " + roll);
                context.addMove(roll);

                if (roll == 6) {
                    context.incrementSixes();
                    if (context.getConsecutiveSixes() == 3) {
                        strategy.handleThreeSixes(context);
                    }
                } else {
                    break;
                }
            }

            if (context.isSkipTurn() && context.getTotalMoveCount() > 0) {
                int newPosition = currentPlayer.getCurrentPosition() + context.getTotalMoveCount();

                if (newPosition > maxCells) {
                    System.out.println("Needs exactly " + (maxCells - currentPlayer.getCurrentPosition()) + " to win. Stays at " + currentPlayer.getCurrentPosition());
                } else {
                    System.out.println(currentPlayer.getName() + " moves to cell " + newPosition);

                    Optional<BoardEntity> entity = board.getEntity(newPosition);
                    if (entity.isPresent()) {
                        int finalPosition = entity.get().apply();
                        currentPlayer.setCurrentPosition(finalPosition);
                    } else {
                        currentPlayer.setCurrentPosition(newPosition);
                    }
                }
            }

            if (currentPlayer.getCurrentPosition() == maxCells) {
                System.out.println("*** " + currentPlayer.getName() + " HAS FINISHED! Rank: " + rank + " ***");
                rank++;
            } else {
                playerQueue.offer(currentPlayer);
            }
        }

        System.out.println("\nGame Over! " + playerQueue.poll().getName() + " is the last player standing.");
    }
}
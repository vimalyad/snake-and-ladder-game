package SnakeAndLadderGame.src.entity;

import SnakeAndLadderGame.src.enums.Difficulty;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Board board;
    private final List<Player> players;
    private final Dice dice;
    private final Difficulty difficulty;
    private final List<Player> winners;

    public Game(Board board, Difficulty difficulty, List<Player> players, Dice dice) {
        this.board = board;
        this.difficulty = difficulty;
        this.players = players;
        this.dice = dice;
        this.winners = new ArrayList<>();
    }

    public void addWinner(Player winner) {
        if (this.winners.contains(winner)) {
            throw new IllegalArgumentException("Player " + winner + " has already won!");
        }
        this.winners.add(winner);
    }
}
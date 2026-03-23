package SnakeAndLadderGame.src.factory;

import SnakeAndLadderGame.src.engine.Game;
import SnakeAndLadderGame.src.entity.Board;
import SnakeAndLadderGame.src.entity.Dice;
import SnakeAndLadderGame.src.entity.Player;
import SnakeAndLadderGame.src.strategy.DifficultyStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameFactory {

    public static Game createGame(int n, int numPlayers, String difficulty) {
        if (numPlayers <= 1) throw new IllegalArgumentException("Number of players must be greater than 1");

        Board board = BoardFactory.createBoard(n);
        DifficultyStrategy strategy = DifficultyFactory.getStrategy(difficulty);

        Dice dice = DiceFactory.createDice(6);
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player("Player " + i));
        }

        return new Game(board, strategy, players, dice);
    }
}
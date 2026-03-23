package SnakeAndLadderGame.src;

import SnakeAndLadderGame.src.engine.Game;
import SnakeAndLadderGame.src.factory.GameFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter board dimension 'n' (nxn board): ");
        int n = scanner.nextInt();

        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();

        System.out.print("Enter difficulty (easy/hard): ");
        String difficultyInput = scanner.next();

        Game game = GameFactory.createGame(n, numPlayers, difficultyInput);

        game.play();

        scanner.close();
    }
}
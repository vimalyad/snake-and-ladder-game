# 🐍🪜 Snake and Ladder Game

A robust, terminal-based Snake and Ladder game engineered in Java. This project emphasizes clean architecture, applying
SOLID principles, the Strategy Pattern, and the Factory Pattern to create a highly extensible and maintainable codebase.

## ✨ Features

* **Dynamic Board Generation:** Play on any $N \times N$ board size.
* **Smart Entity Placement:** Automatically generates $N$ Snakes and $N$ Ladders. The algorithm mathematically
  guarantees that entities do not overlap, do not start/end on the same row (preventing horizontal moving walkways), and
  do not create infinite loops.
* **Multiplayer Support:** Supports a custom number of players taking turns in a continuous loop.
* **Configurable Difficulty Levels:**
    * **Easy:** Rolling three consecutive 6s resets your counter and grants another roll.
    * **Hard:** Rolling three consecutive 6s instantly ends your turn and forfeits all accumulated movement for that
      turn.
* **Cycle-Free Architecture:** Utilizes a `TurnContext` to prevent "Ghost Movements" and decouple game rules from the
  main execution loop.

## 🏗️ Architecture & UML Class Diagram

The application is strictly divided into Entities (State), Strategies (Rules), Factories (Creation), and the Engine (
Execution) to ensure zero architectural overlap.

```mermaid
classDiagram
    %% Core Engine & Factories
    class Main {
        +main(args: String[])
    }
    class GameFactory {
        +createGame(n: int, numPlayers: int, difficulty: String): Game
    }
    class BoardFactory {
        +createBoard(n: int): Board
    }
    class DifficultyFactory {
        +getStrategy(difficulty: String): DifficultyStrategy
    }
    class Game {
        -board: Board
        -strategy: DifficultyStrategy
        -playerQueue: Queue~Player~
        -dice: Dice
        +play()
    }

    %% Entities
    class Board {
        -size: int
        -boardEntityMap: Map~Integer, BoardEntity~
        +addEntity(position: int, entity: BoardEntity)
        +totalCells(): int
        +getEntity(position: int): Optional~BoardEntity~
    }
    class BoardEntity {
        <<abstract>>
        -start: int
        -end: int
        +apply(): int
        +getStart(): int
        +getEnd(): int
    }
    class Snake {
        +apply(): int
    }
    class Ladder {
        +apply(): int
    }
    class Player {
        -name: String
        -currentPosition: int
        +getName(): String
        +getCurrentPosition(): int
        +setCurrentPosition(pos: int)
    }
    class Dice {
        -sides: int
        +roll(): int
    }
    class TurnContext {
        -skipTurn: boolean
        -consecutiveSixes: int
        -totalMoveCount: int
        +incrementSixes()
        +getConsecutiveSixes(): int
        +resetSixes()
        +addMove(amount: int)
        +getTotalMoveCount(): int
        +triggerSkip()
        +isSkipTurn(): boolean
    }

    %% Strategies
    class DifficultyStrategy {
        <<interface>>
        +handleThreeSixes(context: TurnContext)
    }
    class EasyDifficultyStrategy {
        +handleThreeSixes(context: TurnContext)
    }
    class HardDifficultyStrategy {
        +handleThreeSixes(context: TurnContext)
    }

    %% Relationships
    Main --> GameFactory : Uses
    GameFactory --> Game : Creates
    GameFactory --> BoardFactory : Uses
    GameFactory --> DifficultyFactory : Uses
    
    Game --> Board : Has-A
    Game --> DifficultyStrategy : Has-A
    Game --> Player : Manages Queue
    Game --> Dice : Uses
    Game ..> TurnContext : Creates per turn
    
    Board "1" *-- "*" BoardEntity : Contains
    BoardEntity <|-- Snake
    BoardEntity <|-- Ladder
    
    DifficultyStrategy <|-- EasyDifficultyStrategy
    DifficultyStrategy <|-- HardDifficultyStrategy
    DifficultyStrategy ..> TurnContext : Modifies State
```

## 🚀 How to Run

### Prerequisites

* Java Development Kit (JDK) 11 or higher installed on your machine.

### Compilation & Execution

1. Clone the repository and navigate to the root directory.
2. Compile the Java files:
   ```bash
   javac SnakeAndLadderGame/src/*.java
   ```
3. Run the application:
   ```bash
   java SnakeAndLadderGame.src.Main
   ```

### Gameplay Instructions

Upon starting the game, you will be prompted to enter:

1. **Board Dimension ($N$):** Enter a number (e.g., `10` for a standard 100-cell board).
2. **Number of Players:** Enter the total amount of players.
3. **Difficulty:** Type `easy` or `hard`.

The game will automatically simulate the dice rolls and display the action turn-by-turn until one player successfully
lands exactly on the final cell.
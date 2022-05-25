import java.io.IOException;
import java.util.Scanner;

public class MinesweeperTextbased {
  static final char EASY = 'E';
  static final char MEDIUM = 'M';
  static final char HARD = 'H';
  static final char LEARN = 'L';
  static final char PLAY = 'P';
  static String EMPTY_CELL = "  .";
  static String BOMB_CELL = "  @";
  static String SELECTED_EMPTY_CELL = "   ";
  static long RANDOM_SEED_VALUE = 0;

  public static void draw (MinesweeperBoard cMinesweeperBoard,
                           MinesweeperGame.GameMode cGameMode) {
    MinesweeperCell cMinesweeperCell = new MinesweeperCell (EMPTY_CELL);

  // output X (column) numbers
  for (short x = 0; x < cMinesweeperBoard.mRows; x++) {
    // draw spaces before each number
    for (short space = 0;
      // subtracting off digits in number
         space < cMinesweeperBoard.mcCells[0][0].getContants ().length () - x / 10 - 1;
         space++) {
      System.out.print (" ");
    }
    System.out.print (x + " ");
  }
  System.out.println ();
  System.out.println ();

  for (short y = 0; y < cMinesweeperBoard.mColumns; y++) {
    for (short x = 0; x < cMinesweeperBoard.mRows; x++) {
      if (cGameMode == MinesweeperGame.GameMode.PLAY &&
        cMinesweeperBoard.mcCells[x][y] instanceof Bomb) {
        System.out.print (cMinesweeperCell.getContants () +
          "|");
      }
      else {
        System.out.print (cMinesweeperBoard.mcCells[x][y].getContants () +
          "|");
      }
    }
    System.out.format ("%4d ", y);
    System.out.println ();

    // Print out the dashes between each row of cell
    for (short k = 0;
         k < (cMinesweeperBoard.mcCells[0][0].getContants ().length () + 1 ) *
           cMinesweeperBoard.getNumRows (); k++) {
      System.out.format ("-");
    }
    System.out.println ();
  }
}

  public static MinesweeperGame.Difficulty checkDifficulty
    (char difficulty) throws IOException {
    MinesweeperGame.Difficulty cDifficulty;

    if (difficulty == EASY) {
      cDifficulty = MinesweeperGame.Difficulty.EASY;
    }
    else if (difficulty == MEDIUM) {
      cDifficulty = MinesweeperGame.Difficulty.MEDIUM;
    }
    else if (difficulty == HARD) {
      cDifficulty = MinesweeperGame.Difficulty.HARD;
    }
    else {
      throw new IOException ("Illegal Difficulty Level");
    }
    return cDifficulty;
  }

  public static MinesweeperGame.GameMode checkGameMode
    (char gameMode) throws IOException {
    MinesweeperGame.GameMode cGameMode;

    if (gameMode == LEARN) {
      cGameMode = MinesweeperGame.GameMode.LEARN;
    }
    else if (gameMode == PLAY) {
      cGameMode = MinesweeperGame.GameMode.PLAY;
    }
    else {
      throw new IOException ("Illegal Game Mode");
    }
    return cGameMode;
  }

  public static void main (String[] args) {
    char difficultyLevel = EASY;
    char playLevel = LEARN;
    MinesweeperGame.Difficulty cDifficulty = MinesweeperGame.Difficulty.EASY;
    MinesweeperGame.GameMode cGameMode = MinesweeperGame.GameMode.LEARN;
    boolean bHitBomb;
    short xCoord, yCoord;

    Scanner input = new Scanner (System.in);

    System.out.print ("***********\nMinesweeper\n***********\n\n");

    System.out.print ("Enter game mode\n" + "L)EARN, P)LAY: ");

    try {
      playLevel = input.next ().charAt (0);
      cGameMode= checkGameMode (playLevel);
    }
    catch (IOException gameModeException) {
      System.out.println ("I/O error: " + gameModeException);
    }

    System.out.print ("\nEnter difficulty level\n" +
      "E)ASY, M)EDIUM, H)ARD): ");

    try {
      difficultyLevel = input.next ().charAt (0);
      cDifficulty = checkDifficulty (difficultyLevel);
    }
    catch (IOException difficultyException) {
      System.out.println ("I/O error: " + difficultyException);
    }

    MinesweeperGame cMineSweeperGame = new MinesweeperGame (cDifficulty,
      cGameMode);

    MinesweeperBoard cMinesweeperBoard =
      new MinesweeperBoard (cMineSweeperGame.getNumRows (),
        cMineSweeperGame.getNumCols (), cMineSweeperGame.getNumBombs (),
      new MinesweeperCell ( EMPTY_CELL), new Bomb (BOMB_CELL),
      RANDOM_SEED_VALUE);

    do {
      System.out.println ();
      draw (cMinesweeperBoard, cGameMode);
      System.out.println ();
      System.out.print ("Enter X and Y Coordinate: ");
      xCoord = input.nextShort ();
      yCoord = input.nextShort ();
      bHitBomb = cMinesweeperBoard.isBomb (xCoord, yCoord);
      if (!bHitBomb)
      {
        cMinesweeperBoard.update (xCoord, yCoord);
      }
      else
      {
        System.out.println ("Boooom!!! You lose.");
      }
    } while (!bHitBomb  && !cMinesweeperBoard.isWon ());

    System.out.println ("Congratulations. You win");

    input.close ();
  }
}

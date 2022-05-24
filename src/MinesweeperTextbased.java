import java.io.IOException;
import java.util.Scanner;

public class MinesweeperTextbased {
/*  public static final short NUM_ROWS = 9;
  public static final short NUM_COLS = 9;

  public static final short ADDIONAL_BOMBS_PER_LEVEL = 3;*/

public static void draw (MinesweeperBoard cMinesweeperBoard) {
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
      //cMinesweeperBoard.mcCells[x][y].draw ();
      System.out.print (cMinesweeperBoard.mcCells[x][y].getContants () +
        "|");
      //System.out.print("|");
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
    (Character difficulty) throws IOException {
    MinesweeperGame.Difficulty cDifficulty;

    if (difficulty == 'E') {
      cDifficulty = MinesweeperGame.Difficulty.EASY;
    }
    else if (difficulty == 'M') {
      cDifficulty = MinesweeperGame.Difficulty.MEDIUM;
    }
    else if (difficulty == 'H') {
      cDifficulty = MinesweeperGame.Difficulty.HARD;
    }
    else {
      throw new IOException ("Illegal Selection");
    }
    return cDifficulty;
  }

  public static void main (String[] args) {
    Character difficultyLevel = 'E';
    MinesweeperGame.Difficulty cDifficulty = MinesweeperGame.Difficulty.EASY;
    boolean bHitBomb;
    // boolean bHitBomb;
    short xCoord, yCoord;

    Scanner input = new Scanner (System.in);

    System.out.print ("***********\nMinesweeper\n***********\n\n");
    System.out.print ("Enter difficulty level\n" +
      "(E)ASY, M)EDIUM, H)ARD): ");

    try {
      difficultyLevel = input.next ().charAt (0);
      cDifficulty = checkDifficulty (difficultyLevel);
    }
    catch (IOException difficultyException) {
      System.out.println ("I/O error: " + difficultyException);
    }

    MinesweeperGame cMineSweeperGame = new MinesweeperGame (cDifficulty,
      MinesweeperGame.GameMode.DEBUG);

    MinesweeperBoard cMinesweeperBoard =
      new MinesweeperBoard (cMineSweeperGame.getNumRows (),
        cMineSweeperGame.getNumCols (), cMineSweeperGame.getNumBombs (),
      new MinesweeperCell ( "  ."), new Bomb ("  @"),
      (long) 0);

    do {
      System.out.println ();
      draw (cMinesweeperBoard);
      System.out.println ();
      System.out.print ("Enter X and Y Coordinate: ");
      // User sees 0 1 2 3 ...
      // Actual    9 8 7
      // Visually rotating board 90 clockwise
      xCoord = input.nextShort ();
      //xCoord = (short) (cMinesweeperBoard.getNumRows () - xCoord - 1);
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

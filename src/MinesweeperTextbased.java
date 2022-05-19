import java.io.IOException;
import java.util.Scanner;

public class MinesweeperTextbased {
  public static final short NUM_ROWS = 9;
  public static final short NUM_COLS = 9;
  public static final short INITIAL_BOMBS = (short) Math.sqrt (NUM_COLS * NUM_ROWS);
  public static final short ADDIONAL_BOMBS_PER_LEVEL = 3;


  public static enum Difficulty {
    EASY, MEDIUM, HARD
  }

  public static Difficulty checkDifficulty (Character difficulty) throws IOException {
    Difficulty cDifficulty;

    if (difficulty == 'E') {
      cDifficulty = Difficulty.EASY;
    }
    else if (difficulty == 'M') {
      cDifficulty = Difficulty.MEDIUM;
    }
    else if (difficulty == 'H') {
      cDifficulty = Difficulty.HARD;
    }
    else {
      throw new IOException ("Illegal Selection");
    }
    return cDifficulty;
  }

  public static void main (String[] args) {
    Character difficultyLevel = 'E';
    Difficulty cDifficulty;
    MinesweeperBoard cMinesweeperBoard = new MinesweeperBoard ((short) 9,
      (short) 9, (short) 9,
      new Cell ((short) 0, "", "  ."), new Bomb ((short) 0, "", "  @"),
      (long) 0);
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

    cMinesweeperBoard.draw ();
  }
/*

            MineSweeper mMindSweeper = new MineSweeper (difficultyLevel, BOARD_SIZE);

            do
            {
                System.out.println ();
                mMindSweeper.printBoard ();
                System.out.println ();
                System.out.print ("Enter X and Y Coordinate: ");
                xCoord = input.nextInt ();
                yCoord = input.nextInt ();
                bHitBomb = mMindSweeper.isBomb (xCoord, yCoord);
                if (!bHitBomb)
                {
                    mMindSweeper.processBoard (xCoord, yCoord);
                }
                else
                {
                    System.out.println ("Boooom!!! You lose.");
                }
            } while (!bHitBomb);
            input.close ();*/
  }

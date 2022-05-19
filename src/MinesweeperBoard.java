import java.util.Random;

public class MinesweeperBoard extends Board2D {
  short mNumBombs;

  public MinesweeperBoard (short rows, short columns, short numBombs,
                           Cell cCell, Bomb cBomb, long seed) {
    super (rows, columns, cCell);
    mNumBombs = numBombs;
  }

  public void init (Cell cEmptyCell, Bomb cBombCell, long seed) {
    init (cEmptyCell);

    Random random = new Random (seed);
    int count = 0;
    int randomX, randomY;

    do {
      // horizontal direction is X (columns), vertical direction is Y (rows)
      randomX = random.nextInt (this.mColumns);
      randomY = random.nextInt (this.mRows);
      if (!(this.mcCells[randomX][randomY] instanceof Bomb)) {
        this.mcCells[randomX][randomY] = new Bomb (cBombCell);
        ++count;
      }
    } while (count < mNumBombs);
  }

  public void draw () {
    //int numDashes = (mDimension * 3) + (mDimension - 1);

    // output X (column) numbers
    for (short x = 0; x < this.mColumns; x++) {
      // draw spaces before each number
      for (short j = 0;
           // subtracting off digits in number
           j < this.mcCells[0][0].getContants ().length () - x / 10 - 1;
           j++) {
        System.out.print (" ");
      }
      System.out.print (x);
    }
    System.out.println ();
    System.out.println ();

/*    for (int i = 0; i < mDimension; i++) {
      for (int j = 0; j < mDimension; j++) {
        System.out.format ("  " + maBoard[i][j]);

        // Each cell is contained with a '|' except the final cell which
        // shows the row number
        if (j == mDimension - 1) {
          System.out.format ("%6d ", i);
        } else {
          System.out.format ("|");
        }
      }
      System.out.println ();

      // Print out the dashes between each row of cell
      if (i != mDimension - 1) {
        for (int k = 0; k < numDashes; k++) {
          System.out.format ("-");
        }
        System.out.println ();
      }
    }*/
  }
}
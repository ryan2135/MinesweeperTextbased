import java.util.Random;

public class MinesweeperBoard extends Board2D {
  short mNumBombs;

  public MinesweeperBoard (short rows, short columns, short numBombs,
                           MinesweeperCell cMinesweeperCell,
                           Bomb cBomb,
                           long seed) {
    super (rows, columns, cMinesweeperCell);
    mNumBombs = numBombs;
    addBombs (cBomb, seed);
  }

  public void addBombs (Bomb cBomb, long seed) {

    Random random = new Random (seed);
    int count = 0;
    int randomX, randomY;

    do {
      // horizontal direction is X (columns), vertical direction is Y (rows)
      randomX = random.nextInt (this.mColumns);
      randomY = random.nextInt (this.mRows);
      if (!(this.mcCells[randomX][randomY] instanceof Bomb)) {
        this.mcCells[randomX][randomY] = new Bomb (cBomb);
        ++count;
      }
    } while (count < mNumBombs);
  }

  /*public void draw () {
    //int numDashes = (mDimension * 3) + (mDimension - 1);

    // output X (column) numbers
    for (short x = 0; x < this.mColumns; x++) {
      // draw spaces before each number
      for (short space = 0;
           // subtracting off digits in number
           space < this.mcCells[0][0].getContants ().length () - x / 10 - 1;
           space++) {
        System.out.print (" ");
      }
      System.out.print (x + " ");
    }
    System.out.println ();
    System.out.println ();

    for (int x = 0; x < this.mRows; x++) {
      for (int y = 0; y < this.mColumns; y++) {
        this.mcCells[x][y].draw ();
        System.out.print("|");
      }
      System.out.format ("%4d ", x);
      System.out.println ();

      // Print out the dashes between each row of cell
        for (int k = 0;
             k < (this.mcCells[0][0].getContants ().length () + 1 ) * mColumns; k++) {
          System.out.format ("-");
        }
        System.out.println ();
      }
    }*/
  }
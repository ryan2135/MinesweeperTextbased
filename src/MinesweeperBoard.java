import java.util.Random;

public class MinesweeperBoard extends Board2D {
  short mNumBombs;
  short mNumRevealed;

  public MinesweeperBoard (short rows, short columns, short numBombs,
                           MinesweeperCell cMinesweeperCell,
                           Bomb cBomb,
                           long seed) {
    super (rows, columns, cMinesweeperCell);
    mNumBombs = numBombs;
    mNumRevealed = (short) (rows * columns - numBombs);
    addBombs (cBomb, seed);
  }

  public void addBombs (Bomb cBomb, long seed) {

    Random random = new Random (seed);
    int count = 0;
    int randomX, randomY;

    do {
      // horizontal direction is X (columns), vertical direction is Y (rows)
      randomX = random.nextInt (this.mRows);
      randomY = random.nextInt (this.mColumns);
      if (!(this.mcCells[randomX][randomY] instanceof Bomb)) {
        this.mcCells[randomX][randomY] = new Bomb (cBomb);
        ++count;
      }
    } while (count < mNumBombs);
  }

  public boolean isBomb (short xCoord, short yCoord) {
    return isValidCoordinate (xCoord, yCoord) &&
      this.mcCells[xCoord][yCoord] instanceof Bomb;
  }

  public boolean isValidCoordinate (int xCoord, int yCoord)
  {
    // (x, y) x goes left to right, y goes top to bottom
    return (mRows > xCoord && -1 < xCoord &&
      mColumns > yCoord && -1 < yCoord);
  }
  public short adjacentBombs (short xCoord, short yCoord) {
    short totalAdjacentBombs = 0;
    short one = 1;

    // (0, 0) is upper-left on board
    if (isBomb ((short) (xCoord - 1), (short) (yCoord - 1))) { // upper-left
      totalAdjacentBombs++;
    }
    if (isBomb (xCoord, (short) (yCoord - 1))) { // upper-middle
      totalAdjacentBombs++;
    }
    if (isBomb ((short) (xCoord + 1), (short) (yCoord - 1))) { // upper-right
      totalAdjacentBombs++;
    }
    if (isBomb ((short) (xCoord - 1), yCoord)) { // middle-left
      totalAdjacentBombs++;
    }
    if (isBomb ((short) (xCoord + 1), yCoord)) { // middle-right
      totalAdjacentBombs++;
    }
    if (isBomb ((short) (xCoord -1), (short) (yCoord + 1))) { // lower-left
      totalAdjacentBombs++;
    }
    if (isBomb (xCoord, (short) (yCoord + 1))) { // lower-middle
      totalAdjacentBombs++;
    }
    if (isBomb ((short) (xCoord + 1), (short) (yCoord + 1))) { // lower-right
      totalAdjacentBombs++;
    }

    return totalAdjacentBombs;
  }

  public void update (short xCoord, short yCoord) {
    short numAdjacentBombs;

    // Make sure that the coord is valid and not already visible, or a bomb
    if (isValidCoordinate (xCoord, yCoord) &&
      !mcCells[xCoord][yCoord].isSelected () && !isBomb (xCoord, yCoord))
    {
      // If the cell is adjacent to a bomb then add that value to the board
      numAdjacentBombs = adjacentBombs (xCoord, yCoord);
      if (0 != numAdjacentBombs)
      {
        // Assume number of adjacent bombs is single digit
        mcCells[xCoord][yCoord] =
          new MinesweeperCell ("  " + Short.toString (numAdjacentBombs),
          numAdjacentBombs);
        mcCells[xCoord][yCoord].select ();
        --mNumRevealed;
      }
      // If there are no adjacent bombs then recursively check the cells
      // surrounding the coordinates
      else
      {
        mcCells[xCoord][yCoord] = new MinesweeperCell ("   ");
        mcCells[xCoord][yCoord].select ();
        --mNumRevealed;
        update ((short) (xCoord - 1), (short) (yCoord - 1)); // upper-left
        update (xCoord, (short) (yCoord - 1)); // upper-middle
        update ((short) (xCoord + 1), (short) (yCoord - 1)); // upper-right
        update ((short) (xCoord - 1), yCoord); // middle-left
        update ((short) (xCoord + 1), yCoord); // middle-right
        update ((short) (xCoord -1), (short) (yCoord + 1)); // lower-left
        update (xCoord, (short) (yCoord + 1)); // lower-middle
        update ((short) (xCoord + 1), (short) (yCoord + 1)); // lower-right
      }
    }
  }

  public boolean isWon () {
    return mNumRevealed <= 0;
  }

}
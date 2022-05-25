public class MinesweeperCell extends Cell {
  short mBombNeighbors;

  public MinesweeperCell () {
    super ();
    mBombNeighbors = 0;
  }

  public MinesweeperCell (String cContents) {
    mcContents = cContents;
    mBombNeighbors = 0;
  }

  public MinesweeperCell (String cContents, short adjacentBombs) {
    mcContents = cContents;
    mBombNeighbors = adjacentBombs;
  }

  public MinesweeperCell (MinesweeperCell cMinesweeperCell) {
    mcContents = cMinesweeperCell.mcContents;
    mBombNeighbors = cMinesweeperCell.mBombNeighbors;
  }

  public short getNumBombNeighbors () {
    return mBombNeighbors;
  }
}

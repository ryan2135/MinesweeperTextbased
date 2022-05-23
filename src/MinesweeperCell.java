public class MinesweeperCell extends Cell {
  short mBombNeighbors;

  public MinesweeperCell () {
    super ();
  }

  public MinesweeperCell (String cContents) {
    mcContents = cContents;
    mBombNeighbors = 0;
  }

  public MinesweeperCell (MinesweeperCell cMinesweeperCell) {
    mcContents = cMinesweeperCell.mcContents;
    mBombNeighbors = cMinesweeperCell.mBombNeighbors;
  }

  public short getNumBombNeighbors () {
    return mBombNeighbors;
  }
}

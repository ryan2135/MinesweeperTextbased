public class Board2D {
  protected short mRows;
  protected short mColumns;
  protected Cell mcCells[][];

  public Board2D (short rows, short columns, Cell cCell) {
    mRows = rows;
    mColumns = columns;
    mcCells = new Cell[rows][columns];
    init (cCell);
  }

  public void init (Cell cCell) {
    for (short row = 0; row < mRows; row++) {
      for (short col = 0; col < mColumns; col++) {
        mcCells[row][col] = new Cell (cCell);
      }
    }
  }
}

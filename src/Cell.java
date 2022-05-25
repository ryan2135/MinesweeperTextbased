public class Cell {
  Boolean mcIsSelected;
  String mcContents;

  public Cell () {
    mcIsSelected = false;
    mcContents = "";
  }

  public Cell (String cContents) {
    mcIsSelected = false;
    mcContents = cContents;
  }

  public Cell (Cell cCell) {
    this.mcIsSelected = cCell.mcIsSelected;
    this.mcContents = cCell.mcContents;
  }

  public void select () {
    mcIsSelected = true;
  }

  public boolean isSelected () {
    return mcIsSelected;
  }

  public String getContants () {
    return this.mcContents;
  }
  /*
  For now I"m going to implement a text-based draw cuz I don't know the
  proper design for text, graphics, and sprite draw
   */
/*  public void draw () {
    System.out.print (this.mcContents);
  }*/
}

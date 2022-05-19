public class Cell {
  short mID;
  String mcName;
  Boolean mcIsSelected;
  String mcContents;

  public Cell () {
    mID = 0;
    mcName = "";
    mcIsSelected = false;
  }

  public Cell (short id, String name, String string) {
    mID = id;
    mcName = name;
    mcIsSelected = false;
    mcContents = string;
  }

  public Cell (Cell cCell) {
    this.mID = cCell.mID;
    this.mcName = cCell.mcName;
    this.mcIsSelected = cCell.mcIsSelected;
    this.mcContents = cCell.mcContents;
  }

  public void select () {
    mcIsSelected = true;
  }

  public Boolean isSelected () {
    return mcIsSelected;
  }

  public String getContants () {
    return this.mcContents;
  }
  /*
  For now I"m going to implement a text-based draw cuz I don't know the
  proper design for text, graphics, and sprite draw
   */
  public void draw () {
    System.out.print (this.mcContents);
  }
}

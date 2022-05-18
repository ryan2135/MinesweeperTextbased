import java.util.Scanner;

public class Cell {
  short mID;
  String mcName;
  Boolean mcIsSelected;
  String mcString;

  public Cell () {
    mID = 0;
    mcName = "";
    mcIsSelected = false;
  }

  public Cell (short id, String name, String string) {
    mID = id;
    mcName = name;
    mcIsSelected = false;
    mcString = string;
  }

  public Cell (Cell cCell) {
    this.mID = cCell.mID;
    this.mcName = cCell.mcName;
    this.mcIsSelected = cCell.mcIsSelected;
    this.mcString = cCell.mcString;
  }

  public void select () {
    mcIsSelected = true;
  }

  public Boolean isSelected () {
    return mcIsSelected;
  }

  /*
  For now I"m going to implement a text-based draw cuz I don't know the
  proper design for text, graphics, and sprite draw
   */
  public void draw () {
    System.out.print (this.mcString);
  }
}

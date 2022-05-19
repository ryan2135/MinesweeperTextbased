public class Bomb extends Cell {
  public Bomb (short id, String name, String contents) {
    super (id, name, contents);
  }

  public Bomb (Bomb cBomb) {
    super (cBomb.mID, cBomb.mcName, cBomb.mcContents);
  }
}

public class Bomb extends MinesweeperCell {

  public Bomb () {
    super ();
  }

  public Bomb (String cContents) {
    super (cContents);
  }

  public Bomb (Bomb cBomb) {
    super (cBomb.mcContents);
  }
}

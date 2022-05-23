public class MinesweeperGame {
  // The following information could be determined from the screen size
  // I'm just hard coding for now
  public static final short NUM_ROWS = 9;
  public static final short NUM_COLS = 9;
  public static final short NUM_INITIAL_BOMBS =
    (short) Math.sqrt (NUM_COLS * NUM_ROWS);
  public static final short ADDITIONAL_BOMBS_PER_LEVEL = 3;

  public static enum Difficulty {
    EASY, MEDIUM, HARD
  }

  public static enum GameMode {
    REAL, DEBUG
  }

  Difficulty mcGameDifficulty;
  GameMode mcGameMode;
  short mNumRows, mNumCols, mInitialBombs, mAdditionalBombsPerLevel;

  MinesweeperGame (Difficulty cDifficulty, GameMode cGameMode) {
    mcGameDifficulty = cDifficulty;
    mcGameMode = cGameMode;
    mNumRows = NUM_ROWS;
    mNumCols = NUM_COLS;
    mInitialBombs = NUM_INITIAL_BOMBS;
    mAdditionalBombsPerLevel = ADDITIONAL_BOMBS_PER_LEVEL;
  }

  MinesweeperGame (short numRows, short numCols,
                   short numBombs, Difficulty cDifficulty,
                   GameMode cGameMode) {
    mcGameDifficulty = cDifficulty;
    mcGameMode = cGameMode;
    mNumRows = numRows;
    mNumCols = numCols;
    mInitialBombs = NUM_INITIAL_BOMBS;
    mAdditionalBombsPerLevel = ADDITIONAL_BOMBS_PER_LEVEL;
  }

  public short getNumRows () {
    return mNumRows;
  }

  public short getNumCols () {
    return mNumCols;
  }

  public short getNumBombs () {
    return (short) (mInitialBombs +
          (short) mcGameDifficulty.ordinal () * ADDITIONAL_BOMBS_PER_LEVEL);
  }
}

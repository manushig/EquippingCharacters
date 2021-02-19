package game;

/**
 * IBattle, it is a place where battle prediction will take place between
 * players.
 * <ul>
 * <li>Winner could be predicted as the one that would last the most number of
 * rounds.
 * <li>There could be tie if players would last the same number of rounds.
 * </ul>
 */
public interface IBattle {
  /**
   * Perform a battle prediction between two players.
   * 
   * @param playersTotalHealth This is Player's Health
   * @return a prediction of the battle
   * @throws IllegalArgumentException If Player's total health value is null or
   *                                  Player's Hit points value is null
   * @throws IllegalArgumentException If Player's total health value is 0
   */
  public String predictWinner(int playersTotalHealth);
}

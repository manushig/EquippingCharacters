package game;

import javafx.util.Pair;

/**
 * ICharacter, it is a place where one can keep track of all of the items that a
 * character is wearing at any given time during the game. it also provide the
 * following functionality.
 * <ul>
 * <li>Character can have maximum of 1 Head Gear, 2 Foot wears, 10 Hand Gears
 * and no limit on Jewelry.
 * <li>Character can pick up new items based on how many items of a particular
 * type that they can wear.
 * <li>The attack or defensive power of the items that a character is wearing
 * temporarily adds to the players attack power and defensive strength.
 * <li>Characters that continue to wear and use worn-out items find that these
 * items decrease their basic attack power and defensive strength.
 * <li>
 * </ul>
 */
public interface ICharacter {
  /**
   * Dress a character with a given item if its compatible or replace it better
   * gear, otherwise discard the gear.
   * 
   * @param gear This is a gear which characters need to put on.
   * @return an ICharacter object.
   * @throws IllegalArgumentException If IsGearAllowed or gear values are null
   */
  public String dressUpGear(IGear gear) throws IllegalArgumentException;

  /**
   * Get details of the character in the battle along with what they are wearing
   * and their attack and defense strength.
   * 
   * @return the details of the character.
   * 
   */
  public String getCharacterDetails();

  /**
   * Retrieve total character strength in given round.
   * 
   * @param round This is round number of the match.
   * @return total character hit points which include Character Attack Value and
   *         Character Defense Value.
   * 
   * @throws IllegalArgumentException If Round value is 0 or null
   */
  public Pair<Integer, Integer> characterTotalStrength(int round) throws IllegalArgumentException;

  /**
   * Get details of the character hit points value.
   * 
   * @return the character hit points value.
   * 
   */
  public int getCharacterHitPoints();

  /**
   * Perform a battle prediction between two players.
   * 
   * @param player2 This is Player 2
   * @return a prediction of the battle
   * @throws IllegalArgumentException If Player2 value is null
   */
  public String predictWinner(ICharacter player2) throws IllegalArgumentException;
}

package rolePlayingGame;

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
   * Gear otherwise discard the gear.
   * 
   * @param gear This is a gear which characters need to put on.
   * @return an ICharacter object.
   * @throws NullPointerException If IsGearAllowed or gear values are null
   */
  public ICharacter dressUpGear(IGear gear);

  /**
   * Get details of the character in the battle along with what they are wearing
   * and their attack and defense strength.
   * 
   * @return the details of the character.
   * @throws NullPointerException if Head Gear Description or Foot wear
   *                              Description or Hand Gear Description or Jewelry
   *                              Description or Total Attack or Total defense
   *                              values are null.
   */
  public String getCharacterDetails();

  /**
   * Retrieve total character hit points in given round.
   * 
   * @param round This is round number of the match.
   * @return total character hit points which include Character Attack Value and
   *         Character Defense Value.
   * @throws NullPointerException     if Round value is null
   * @throws IllegalArgumentException If Round value is 0
   */
  public Pair<Integer, Integer> characterHitPoints(int round);
}

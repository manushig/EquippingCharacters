package rolePlayingGame;

/**
 * IGear, it is a place where it maintains the items details.
 * <ul>
 * <li>Head gear: These items go on the character’s head (hats/helmets/visors)
 * and are only useful for defense.
 * <li>Foot wear: These items go on the character’s feet (boots/sneakers) and
 * are only used for attack. Since character's have 2 feet, they can have 2 of
 * these items.
 * <li>Hand gear: These items go on the character’s fingers/hands and can be for
 * either attack or defense. Since character's have 10 fingers, they can have 10
 * of these items.
 * <li>Jewelry: These items go around the character's neck and can be used for
 * either attack or defense. There is no limit to the number of these items that
 * the character can have.
 * <li>Some items wear out with each use and thus their benefit decreases each
 * time a player uses them.
 * </ul>
 */
public interface IGear extends Comparable<IGear> {
  /**
   * This method allows the visitor access to the element.
   * 
   * @param visitor This is a visitor which requires the access to the element.
   * @throws NullPointerException If Visitor Value is null.
   */
  public void accept(GearVisitor visitor);
}

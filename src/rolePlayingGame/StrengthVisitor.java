package rolePlayingGame;

/**
 * StrengthVisitor, declare the visit operations for all the types of classes of
 * type IStrength which can be visited.
 * <ul>
 * <li>A gear can either have defense value or attack value. Strength visitor
 * separates the logic to calculate total attack value and total defense value
 * of Gear and Character.
 * </ul>
 */

public interface StrengthVisitor {
  /**
   * This method allows the visitor to visit and access the element of Attack.
   * 
   * @param attack This is an attack object.
   */
  public void visit(Attack attack);

  /**
   * This method allows the visitor to visit and access the element of Defence.
   * 
   * @param defence This is a defense object.
   * @throws NullPointerException If Attack or Defense value is null
   */
  public void visit(Defense defence);
}

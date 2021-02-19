package game;

/**
 * StrengthVisitor, declare the visit operations for all the types of classes of
 * type IStrength which can be visited.
 */

public interface StrengthVisitor {
  /**
   * This method allows the visitor to visit and access the element of Attack.
   * 
   * @param attack This is an attack object.
   * @throws IllegalArgumentException If Attack value is null
   */
  public void visit(Attack attack) throws IllegalArgumentException;

  /**
   * This method allows the visitor to visit and access the element of Defense.
   * 
   * @param defence This is a defense object.
   * @throws IllegalArgumentException If Defense value is null
   */
  public void visit(Defense defence) throws IllegalArgumentException;
}

package rolePlayingGame;

/**
 * IStrength, it is a place where it maintains the gear's attack and defense
 * values.
 * 
 */
public interface IStrength extends Comparable<IStrength> {
  /**
   * This method allows the visitor access to the element.
   * 
   * @param visitor This is a visitor which requires the access to the element.
   * @throws NullPointerException If Visitor Value is null
   */
  public void accept(StrengthVisitor visitor);

}

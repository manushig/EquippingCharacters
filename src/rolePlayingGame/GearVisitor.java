package rolePlayingGame;

/**
 * GearVisitor, declare the visit operations for all the types of classes of
 * type IGear which can be visited.
 * <ul>
 * <li>Character can have maximum of 1 Head Gear, 2 Foot wears, 10 Hand Gears
 * and no limit on Jewelry.
 * <li>When describing what a character is wearing, the names of items of the
 * same type are combined.
 * </ul>
 */

public interface GearVisitor {
  /**
   * This method allows the visitor to visit and access the element of HeadGear.
   * 
   * @param attack This is an HeadGear object.
   * @throws NullPointerException HeadGear object value is null
   */
  public void visit(HeadGear headGear);

  /**
   * This method allows the visitor to visit and access the element of Footwear.
   * 
   * @param attack This is an Footwear object.
   * @throws NullPointerException Footwear object value is null
   */
  public void visit(Footwear footwear);

  /**
   * This method allows the visitor to visit and access the element of HandGear.
   * 
   * @param attack This is an HandGear object.
   * @throws NullPointerException HandGear object value is null
   */
  public void visit(HandGear handGear);

  /**
   * This method allows the visitor to visit and access the element of Jewelry.
   * 
   * @param attack This is an Jewelry object.
   * @throws NullPointerException Jewelry object value is null
   */
  public void visit(Jewelry jewelry);
}

package game;

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
   * @param headGear This is an HeadGear object.
   * @throws IllegalArgumentException HeadGear object value is null
   */
  public void visit(HeadGear headGear) throws IllegalArgumentException;

  /**
   * This method allows the visitor to visit and access the element of Footwear.
   * 
   * @param footwear This is an Footwear object.
   * @throws IllegalArgumentException Footwear object value is null
   */
  public void visit(Footwear footwear) throws IllegalArgumentException;

  /**
   * This method allows the visitor to visit and access the element of HandGear.
   * 
   * @param handGear This is an HandGear object.
   * @throws IllegalArgumentException HandGear object value is null
   */
  public void visit(HandGear handGear) throws IllegalArgumentException;

  /**
   * This method allows the visitor to visit and access the element of Jewelry.
   * 
   * @param jewelry This is an Jewelry object.
   * @throws IllegalArgumentException Jewelry object value is null
   */
  public void visit(Jewelry jewelry) throws IllegalArgumentException;
}

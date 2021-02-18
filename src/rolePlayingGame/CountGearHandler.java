package rolePlayingGame;

import java.util.Objects;

/**
 * CountGearHandler, manages the count of gear a character is wearing .
 * <ul>
 * <li>Character can have maximum of 1 Head Gear, 2 Foot wears, 10 Hand Gears
 * and no limit on Jewelry.
 * </ul>
 */

public class CountGearHandler implements GearVisitor {
  private int headGearCount;
  private int handGearCount;
  private int footwearCount;
  private int JewelryCount;

  /**
   * Constructs a CountGearHandler
   *
   */
  public CountGearHandler() {
    this.headGearCount = 0;
    this.handGearCount = 0;
    this.footwearCount = 0;
    this.JewelryCount = 0;
  }

  @Override
  public void visit(HeadGear headGear) throws NullPointerException {
    if (Objects.isNull(headGear)) {
      throw new NullPointerException("Head Gear value cannot be null");
    }
    headGearCount = headGearCount + 1;
  }

  @Override
  public void visit(Footwear footwear) throws NullPointerException {
    if (Objects.isNull(footwear)) {
      throw new NullPointerException("Footwear value cannot be null");
    }
    footwearCount = footwearCount + 1;
  }

  @Override
  public void visit(HandGear handGear) throws NullPointerException {
    if (Objects.isNull(handGear)) {
      throw new NullPointerException("Hand Gear value cannot be null");
    }
    handGearCount = handGearCount + 1;
  }

  @Override
  public void visit(Jewelry jewelry) throws NullPointerException {
    if (Objects.isNull(jewelry)) {
      throw new NullPointerException("Jewellry value cannot be null");
    }
    JewelryCount = JewelryCount + 1;
  }

  /**
   * This method gets the count of head gear a character is wearing.
   * 
   * @return the head gear count.
   */
  public int getHeadGearCount() {
    return headGearCount;
  }

  /**
   * This method gets the count of hand gear a character is wearing.
   * 
   * @return the hand gear count.
   */
  public int getHandGearCount() {
    return handGearCount;
  }

  /**
   * This method gets the count of foot wear a character is wearing.
   * 
   * @return the foot wear count.
   */
  public int getFootwearCount() {
    return footwearCount;
  }

  /**
   * This method gets the count of jewelry a character is wearing.
   * 
   * @return the jewelry count.
   */
  public int getJewelryCount() {
    return JewelryCount;
  }

}

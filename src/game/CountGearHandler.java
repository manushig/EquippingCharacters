package game;

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
  private int jewelryCount;

  /**
   * Constructs a CountGearHandler.
   *
   */
  public CountGearHandler() {
    this.headGearCount = 0;
    this.handGearCount = 0;
    this.footwearCount = 0;
    this.jewelryCount = 0;
  }

  @Override
  public void visit(HeadGear headGear) throws IllegalArgumentException {
    if (Objects.isNull(headGear)) {
      throw new IllegalArgumentException("Head Gear value cannot be null");
    }
    headGearCount = headGearCount + 1;
  }

  @Override
  public void visit(Footwear footwear) throws IllegalArgumentException {
    if (Objects.isNull(footwear)) {
      throw new IllegalArgumentException("Footwear value cannot be null");
    }
    footwearCount = footwearCount + 1;
  }

  @Override
  public void visit(HandGear handGear) throws IllegalArgumentException {
    if (Objects.isNull(handGear)) {
      throw new IllegalArgumentException("Hand Gear value cannot be null");
    }
    handGearCount = handGearCount + 1;
  }

  @Override
  public void visit(Jewelry jewelry) throws IllegalArgumentException {
    if (Objects.isNull(jewelry)) {
      throw new IllegalArgumentException("Jewellry value cannot be null");
    }
    jewelryCount = jewelryCount + 1;
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
    return jewelryCount;
  }

}

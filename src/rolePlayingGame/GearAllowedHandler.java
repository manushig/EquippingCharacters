package rolePlayingGame;

import java.util.Objects;

/**
 * GearAllowedHandler, checks whether a gear can be added to the list without
 * comparing with the existing list of gears.
 * <ul>
 * <li>Character can have maximum of 1 Head Gear, 2 Foot wears, 10 Hand Gears
 * and no limit on Jewelry.
 * </ul>
 */
public class GearAllowedHandler implements GearVisitor {

  private int currentHeadGearCount;
  private int currentHandGearCount;
  private int currentFootwearCount;
  private Boolean isAllowed;

  /**
   * Constructs a GearAllowedHandler in terms of Current Head Gear Count, Hand
   * Gear Count and Current Footwear Count.
   *
   * @param currentHeadGearCount It is the Current Head Gear Count
   * @param currentHandGearCount It is the Current Hand Gear Count
   * @param currentFootwearCount It is the Current Footwear Count
   * @throws NullPointerException If Current Head Gear Count or Current Hand Gear
   *                              Count or Current Footwear Count value is null.
   */
  public GearAllowedHandler(int currentHeadGearCount, int currentHandGearCount,
      int currentFootwearCount) throws NullPointerException {
    if (Objects.isNull(currentHeadGearCount)) {
      throw new NullPointerException("Current Head Gear Count value cannot be null");
    }
    if (Objects.isNull(currentHandGearCount)) {
      throw new NullPointerException("Current Hand Gear Count value cannot be null");
    }
    if (Objects.isNull(currentFootwearCount)) {
      throw new NullPointerException("Current Footwear Count value cannot be null");
    }
    this.currentHeadGearCount = currentHeadGearCount;
    this.currentHandGearCount = currentHandGearCount;
    this.currentFootwearCount = currentFootwearCount;
    this.isAllowed = false;
  }

  @Override
  public void visit(HeadGear headGear) throws NullPointerException {
    if (Objects.isNull(headGear)) {
      throw new NullPointerException("Head Gear value cannot be null");
    }
    if (currentHeadGearCount < 1) {
      this.isAllowed = true;
    } else {
      this.isAllowed = false;
    }
  }

  @Override
  public void visit(Footwear footwear) throws NullPointerException {
    if (Objects.isNull(footwear)) {
      throw new NullPointerException("Footwear value cannot be null");
    }
    if (currentFootwearCount < 2) {
      this.isAllowed = true;
    } else {
      this.isAllowed = false;
    }
  }

  @Override
  public void visit(HandGear handGear) throws NullPointerException {
    if (Objects.isNull(handGear)) {
      throw new NullPointerException("Hand Gear value cannot be null");
    }
    if (currentHandGearCount < 10) {
      this.isAllowed = true;
    } else {
      this.isAllowed = false;
    }
  }

  /**
   * This method tells whether a gear can be added to the list without comparing.
   * 
   * @return whether a gear can be added to the list without comparing.
   */
  public Boolean getIsAllowed() {
    return this.isAllowed;
  }

  @Override
  public void visit(Jewelry jewelry) throws NullPointerException {
    if (Objects.isNull(jewelry)) {
      throw new NullPointerException("Jewellry value cannot be null");
    }
    this.isAllowed = true;
  }

}

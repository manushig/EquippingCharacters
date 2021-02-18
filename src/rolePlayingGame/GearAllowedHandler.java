package rolePlayingGame;

import java.util.Objects;

public class GearAllowedHandler implements GearVisitor {

  private int currentHeadGearCount;
  private int currentHandGearCount;
  private int currentFootwearCount;
  private Boolean isAllowed = false;

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

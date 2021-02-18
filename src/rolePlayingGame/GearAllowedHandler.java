package rolePlayingGame;

import java.util.Objects;

public class GearAllowedHandler implements GearVisitor {

  private int currentHeadGearCount;
  private int currentHandGearCount;
  private int currentFootwearCount;
  private Boolean isAllowed = false;

  public GearAllowedHandler(int currentHeadGearCount, int currentHandGearCount,
      int currentFootwearCount) throws IllegalArgumentException {
    if (Objects.isNull(currentHeadGearCount)) {
      throw new IllegalArgumentException("Current Head Gear Count value cannot be null");
    }
    if (Objects.isNull(currentHandGearCount)) {
      throw new IllegalArgumentException("Current Hand Gear Count value cannot be null");
    }
    if (Objects.isNull(currentFootwearCount)) {
      throw new IllegalArgumentException("Current Footwear Count value cannot be null");
    }
    this.currentHeadGearCount = currentHeadGearCount;
    this.currentHandGearCount = currentHandGearCount;
    this.currentFootwearCount = currentFootwearCount;
  }

  @Override
  public void visit(HeadGear headGear) throws IllegalArgumentException {
    if (Objects.isNull(headGear)) {
      throw new IllegalArgumentException("Head Gear value cannot be null");
    }
    if (currentHeadGearCount < 1) {
      this.isAllowed = true;
    } else {
      this.isAllowed = false;
    }
  }

  @Override
  public void visit(Footwear footwear) throws IllegalArgumentException {
    if (Objects.isNull(footwear)) {
      throw new IllegalArgumentException("Footwear value cannot be null");
    }
    if (currentFootwearCount < 2) {
      this.isAllowed = true;
    } else {
      this.isAllowed = false;
    }
  }

  @Override
  public void visit(HandGear handGear) throws IllegalArgumentException {
    if (Objects.isNull(handGear)) {
      throw new IllegalArgumentException("Hand Gear value cannot be null");
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
  public void visit(Jewelry jewelry) throws IllegalArgumentException {
    if (Objects.isNull(jewelry)) {
      throw new IllegalArgumentException("Jewellry value cannot be null");
    }
    this.isAllowed = true;
  }

}

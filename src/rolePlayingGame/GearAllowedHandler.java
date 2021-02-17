package rolePlayingGame;

public class GearAllowedHandler implements GearVisitor {

  private int currentHeadGearCount;
  private int currentHandGearCount;
  private int currentFootwearCount;
  private int currentJewelryCount;
  private Boolean isAllowed = false;

  public GearAllowedHandler(int currentHeadGearCount, int currentHandGearCount,
      int currentFootwearCount, int currentJewelryCount) {
    this.currentHeadGearCount = currentHeadGearCount;
    this.currentHandGearCount = currentHandGearCount;
    this.currentFootwearCount = currentFootwearCount;
    this.currentJewelryCount = currentJewelryCount;
  }

  @Override
  public void visit(HeadGear headGear) {
    if (currentHeadGearCount < 1) {
      this.isAllowed = true;
    } else {
      this.isAllowed = false;
    }
  }

  @Override
  public void visit(Footwear footwear) {
    if (currentFootwearCount < 2) {
      this.isAllowed = true;
    } else {
      this.isAllowed = false;
    }
  }

  @Override
  public void visit(HandGear handGear) {
    if (currentHandGearCount < 5) {
      this.isAllowed = true;
    } else {
      this.isAllowed = false;
    }
  }

  public Boolean getIsAllowed() {
    return isAllowed;
  }

  @Override
  public void visit(Jewelry jewelry) {
    this.isAllowed = true;
  }

}

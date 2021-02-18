package rolePlayingGame;

import java.util.Objects;

public class CountGearHandler implements GearVisitor {
  private int headGearCount = 0;
  private int handGearCount = 0;
  private int footwearCount = 0;
  private int JewelryCount = 0;

  @Override
  public void visit(HeadGear headGear) throws IllegalArgumentException {
    if (Objects.isNull(headGear)) {
      throw new IllegalArgumentException("Head Gear value cannot be null");
    }
    headGearCount += headGear.getCount();
  }

  @Override
  public void visit(Footwear footwear) throws IllegalArgumentException {
    if (Objects.isNull(footwear)) {
      throw new IllegalArgumentException("Footwear value cannot be null");
    }
    footwearCount += footwear.getCount();
  }

  @Override
  public void visit(HandGear handGear) throws IllegalArgumentException {
    if (Objects.isNull(handGear)) {
      throw new IllegalArgumentException("Hand Gear value cannot be null");
    }
    handGearCount += handGear.getCount();
  }

  @Override
  public void visit(Jewelry jewelry) throws IllegalArgumentException {
    if (Objects.isNull(jewelry)) {
      throw new IllegalArgumentException("Jewellry value cannot be null");
    }
    JewelryCount += jewelry.getCount();
  }

  public int getHeadGearCount() {
    return headGearCount;
  }

  public int getHandGearCount() {
    return handGearCount;
  }

  public int getFootwearCount() {
    return footwearCount;
  }

  public int getJewelryCount() {
    return JewelryCount;
  }

}

package rolePlayingGame;

public class CountGearHandler implements GearVisitor{
  private int headGearCount = 0;
  private int handGearCount = 0;
  private int footwearCount = 0;
  private int JewelryCount = 0;

  @Override
  public void visit(HeadGear headGear) {
    headGearCount += headGear.getCount();
  }

  @Override
  public void visit(Footwear footwear) {
    footwearCount += footwear.getCount();
  }

  @Override
  public void visit(HandGear handGear) {
    handGearCount += handGear.getCount();
  }

  @Override
  public void visit(Jewelry jewelry) {
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

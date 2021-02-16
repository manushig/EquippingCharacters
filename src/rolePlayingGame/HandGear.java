package rolePlayingGame;

public class HandGear extends AbstractGear {

  private IStrength strength;
  private int count = 1;

  public HandGear(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      IStrength gearStrength) {
    super(gearFullName, gearAdjectiveName, wornOutPercentage);
    this.strength = gearStrength;
  }
  
  @Override
  public int compareTo(IGear o) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public IGear isAllowed(IGear gear) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected IGear isAllowedHandGear(HandGear gear) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected IGear isAllowedFootwear(Footwear gear) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected IGear isAllowedHeadGear(HeadGear gear) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected IGear isAllowedJewelry(Jewelry gear) {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public void accept(GearVisitor visitor) {
    visitor.visit(this);
    
  }
  
  @Override
  public int getCount() {
    return count;
  }

}

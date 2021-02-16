package rolePlayingGame;

public class HeadGear extends AbstractGear {

  private IStrength defenceStrength;
  private int allowedCount = 1;
  private int count =1;
  
  public HeadGear(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      int gearDefenceStrength) {
    super(gearFullName, gearAdjectiveName, wornOutPercentage);
    this.defenceStrength = new Defence(gearDefenceStrength);
  }

  @Override
  public int compareTo(IGear o) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public IGear isAllowed(IGear other) {
    if (other instanceof AbstractGear) {
      AbstractGear gear = (AbstractGear) other;
      return gear.isAllowedHeadGear(this);
    } else {
      super.setResult(false);
      return this;
    }
  }

  @Override
  protected IGear isAllowedHeadGear(HeadGear gear) {

    return this;
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

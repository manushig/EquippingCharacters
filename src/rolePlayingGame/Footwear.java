package rolePlayingGame;

public class Footwear extends AbstractGear {

  private IStrength attackStrength;
  private int count = 1;

  public Footwear(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      int gearAttackStrength) {
    super(gearFullName, gearAdjectiveName, wornOutPercentage);
    this.attackStrength = new Attack(gearAttackStrength);
  }

  @Override
  public int compareTo(IGear arg0) {
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

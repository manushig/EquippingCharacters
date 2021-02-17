package rolePlayingGame;

public class HeadGear extends AbstractGear {

  private IStrength defenceStrength;
  private int count = 1;

  public HeadGear(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      int gearDefenceStrength) {
    super(gearFullName, gearAdjectiveName, wornOutPercentage);
    this.defenceStrength = new Defence(gearDefenceStrength);
  }

  @Override
  public int compareTo(IGear other) {
    if (other instanceof AbstractGear) {
      AbstractGear gear = (AbstractGear) other;
      return gear.compareToHeadGear(this);
    }
    else
    {
      return 1;
    }
  }

  @Override
  protected int compareToHeadGear(HeadGear other) {
    return other.getDefenceStrength().compareTo(this.getDefenceStrength());
  }

  @Override
  public void accept(GearVisitor visitor) {
    visitor.visit(this);

  }

  @Override
  public int getCount() {
    return count;
  }
  
  public IStrength getDefenceStrength() {
    return defenceStrength;
  }

}

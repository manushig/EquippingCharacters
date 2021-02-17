package rolePlayingGame;

public class HeadGear extends AbstractGear {

  private int count = 1;

  public HeadGear(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      IStrength gearDefenceStrength) {
    super(gearFullName, gearAdjectiveName, wornOutPercentage, gearDefenceStrength);
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
    return other.getStrength().compareTo(this.getStrength());
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

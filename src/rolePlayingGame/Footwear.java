package rolePlayingGame;

public class Footwear extends AbstractGear {

  private int count = 1;

  public Footwear(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      IStrength gearAttackStrength) {
    super(gearFullName, gearAdjectiveName, wornOutPercentage, gearAttackStrength);
  }

  @Override
  public void accept(GearVisitor visitor) {
    visitor.visit(this);
  }

  @Override
  public int getCount() {
    return count;
  }

  @Override
  public int compareTo(IGear other) {
    if (other instanceof AbstractGear) {
      AbstractGear gear = (AbstractGear) other;
      return gear.compareToFootwear(this);
    } else {
      return 1;
    }
  }

  @Override
  protected int compareToFootwear(Footwear other) {
    return other.getStrength().compareTo(this.getStrength());
  }

}

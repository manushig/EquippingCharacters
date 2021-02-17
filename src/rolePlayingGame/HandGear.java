package rolePlayingGame;

public class HandGear extends AbstractGear {

  private int count = 1;

  public HandGear(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      IStrength gearStrength) {
    super(gearFullName, gearAdjectiveName, wornOutPercentage, gearStrength);
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
      return gear.compareToHandGear(this);
    } else {
      return 1;
    }
  }

  @Override
  protected int compareToHandGear(HandGear other) {
    return other.getStrength().compareTo(this.getStrength());
  }

}

package rolePlayingGame;

import java.util.Objects;

public class HeadGear extends AbstractGear {

  private int count = 1;

  public HeadGear(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      IStrength gearDefenceStrength) {
    super(Objects.requireNonNull(gearFullName, "Gear Full Name value cannot be null"),
        Objects.requireNonNull(gearAdjectiveName, "Gear Adjective Name value cannot be null"),
        Objects.requireNonNull(wornOutPercentage, "Gear wornout percentage value cannot be null"),
        Objects.requireNonNull(gearDefenceStrength, "Gear Defence Strength cannot be null"));
  }

  @Override
  public int compareTo(IGear other) throws IllegalArgumentException {
    if (Objects.isNull(other)) {
      throw new IllegalArgumentException("Gear Value cannot be null");
    }
    if (other instanceof AbstractGear) {
      AbstractGear gear = (AbstractGear) other;
      return gear.compareToHeadGear(this);
    } else {
      return 1;
    }
  }

  @Override
  protected int compareToHeadGear(HeadGear other) {
    return other.getStrength().compareTo(this.getStrength());
  }

  @Override
  public void accept(GearVisitor visitor) throws IllegalArgumentException {
    if (Objects.isNull(visitor)) {
      throw new IllegalArgumentException("Vsitor Value cannot be null");
    }
    visitor.visit(this);

  }

  @Override
  public int getCount() {
    return count;
  }

}

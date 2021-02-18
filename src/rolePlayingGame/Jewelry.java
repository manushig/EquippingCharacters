package rolePlayingGame;

import java.util.Objects;

public class Jewelry extends AbstractGear {

  private int count = 1;

  public Jewelry(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      IStrength gearStrength) {
    super(Objects.requireNonNull(gearFullName, "Gear Full Name value cannot be null"),
        Objects.requireNonNull(gearAdjectiveName, "Gear Adjective Name value cannot be null"),
        Objects.requireNonNull(wornOutPercentage, "Gear wornout percentage value cannot be null"),
        Objects.requireNonNull(gearStrength, "Gear Strength cannot be null"));
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

  @Override
  public int compareTo(IGear other) throws IllegalArgumentException {
    if (Objects.isNull(other)) {
      throw new IllegalArgumentException("Gear Value cannot be null");
    }

    return -1;
  }

}

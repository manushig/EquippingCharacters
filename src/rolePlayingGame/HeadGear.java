package rolePlayingGame;

import java.util.Objects;

/**
 * HeadGear, these items go on the character’s head (hats/helmets/visors) and
 * are only useful for defense.
 */
public class HeadGear extends AbstractGear {
  /**
   * Constructs a HeadGear in terms of its full name, adjective, worn out
   * percentage and strength.
   *
   * @param gearFullName      It is the full name of the HeadGear.
   * @param gearAdjectiveName It is the adjective name of the HeadGear.
   * @param wornOutPercentage It is the worn out percentage of the HeadGear.
   * @param strength          It is the strength of the HeadGear.
   * @throws NullPointerException If HeadGear Full Name or Adjective Name or
   *                              Strength values are null.
   */

  public HeadGear(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      IStrength gearDefenceStrength) {
    super(Objects.requireNonNull(gearFullName, "Gear Full Name value cannot be null"),
        Objects.requireNonNull(gearAdjectiveName, "Gear Adjective Name value cannot be null"),
        wornOutPercentage,
        Objects.requireNonNull(gearDefenceStrength, "Gear Defence Strength cannot be null"));
  }

  @Override
  public int compareTo(IGear other) throws NullPointerException {
    if (Objects.isNull(other)) {
      throw new NullPointerException("Gear Value cannot be null");
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
    return Objects.requireNonNull(other.getStrength(), "Strength value cannot be null")
        .compareTo(Objects.requireNonNull(this.getStrength(), "Strength value cannot be null"));
  }

  @Override
  public void accept(GearVisitor visitor) throws NullPointerException {
    if (Objects.isNull(visitor)) {
      throw new NullPointerException("Vsitor Value cannot be null");
    }
    visitor.visit(this);

  }

}

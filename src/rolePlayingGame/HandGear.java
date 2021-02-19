package rolePlayingGame;

import java.util.Objects;

/**
 * HandGear, these items go on the character’s fingers/hands and can be for
 * either attack or defense.
 */
public class HandGear extends AbstractGear {
  /**
   * Constructs a HandGear in terms of its full name, adjective, worn out
   * percentage and strength.
   *
   * @param gearFullName      It is the full name of the HandGear.
   * @param gearAdjectiveName It is the adjective name of the HandGear.
   * @param wornOutPercentage It is the worn out percentage of the HandGear.
   * @param strength          It is the strength of the HandGear.
   * @throws NullPointerException If HandGear Full Name or Adjective Name or or
   *                              Strength values are null.
   */

  public HandGear(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      IStrength gearStrength) {
    super(Objects.requireNonNull(gearFullName, "Gear Full Name value cannot be null"),
        Objects.requireNonNull(gearAdjectiveName, "Gear Adjective Name value cannot be null"),
        wornOutPercentage, Objects.requireNonNull(gearStrength, "Gear Strength cannot be null"));
  }

  @Override
  public void accept(GearVisitor visitor) throws NullPointerException {
    if (Objects.isNull(visitor)) {
      throw new NullPointerException("Vsitor Value cannot be null");
    }
    visitor.visit(this);

  }

  @Override
  public int compareTo(IGear other) throws NullPointerException {
    if (Objects.isNull(other)) {
      throw new NullPointerException("Gear Value cannot be null");
    }
    if (other instanceof AbstractGear) {
      AbstractGear gear = (AbstractGear) other;
      return gear.compareToHandGear(this);
    } else {
      return 1;
    }
  }

  @Override
  protected int compareToHandGear(HandGear other) {
    return Objects.requireNonNull(other.getStrength(), "Strength value cannot be null")
        .compareTo(Objects.requireNonNull(this.getStrength(), "Strength value cannot be null"));

  }

}

package game;

import java.util.Objects;

/**
 * Jewelry, these items go around the character's neck and can be used for
 * either attack or defense.
 */
public class Jewelry extends AbstractGear {
  /**
   * Constructs a Jewelry in terms of its full name, adjective, worn out
   * percentage and strength.
   *
   * @param gearFullName      It is the full name of the Jewelry.
   * @param gearAdjectiveName It is the adjective name of the Jewelry.
   * @param wornOutPercentage It is the worn out percentage of the Jewelry.
   * @param gearStrength      It is the strength of the Jewelry.
   * @throws NullPointerException If Jewelry Full Name or Adjective Name or
   *                              Strength values are null.
   */
  public Jewelry(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      IStrength gearStrength) {
    super(Objects.requireNonNull(gearFullName, "Gear Full Name value cannot be null"),
        Objects.requireNonNull(gearAdjectiveName, "Gear Adjective Name value cannot be null"),
        wornOutPercentage, Objects.requireNonNull(gearStrength, "Gear Strength cannot be null"));
  }

  @Override
  public void accept(GearVisitor visitor) {
    Objects.requireNonNull(visitor, "Visitor Value cannot be null").visit(this);
  }

  @Override
  public int compareTo(IGear other) {
    if (Objects.requireNonNull(other, "Gear Value cannot be null") instanceof AbstractGear) {
      AbstractGear gear = (AbstractGear) other;
      return gear.compareToJewelry(this);
    } else {
      return 1;
    }
  }

  @Override
  protected int compareToJewelry(Jewelry other) {
    return Objects.requireNonNull(other.getStrength(), "Strength value cannot be null")
        .compareTo(Objects.requireNonNull(this.getStrength(), "Strength value cannot be null"));

  }

}

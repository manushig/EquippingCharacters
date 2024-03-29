package game;

import java.util.Objects;

/**
 * Footwear, these items go on the character�s feet (boots/sneakers) and are
 * only used for attack.
 */
public class Footwear extends AbstractGear {

  /**
   * Constructs a Footwear in terms of its full name, adjective, worn out
   * percentage and strength.
   *
   * @param gearFullName       It is the full name of the foot wear.
   * @param gearAdjectiveName  It is the adjective name of the foot wear.
   * @param wornOutPercentage  It is the worn out percentage of the foot wear.
   * @param gearAttackStrength It is the strength of the foot wear.
   */

  public Footwear(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      IStrength gearAttackStrength) {
    super(Objects.requireNonNull(gearFullName, "Gear Full Name value cannot be null"),
        Objects.requireNonNull(gearAdjectiveName, "Gear Adjective Name value cannot be null"),
        wornOutPercentage,
        Objects.requireNonNull(gearAttackStrength, "Gear Attack Strength cannot be null"));
  }

  @Override
  public void accept(GearVisitor visitor) {
    Objects.requireNonNull(visitor, "Visitor Value cannot be null").visit(this);
  }

  @Override
  public int compareTo(IGear other) {
    if (Objects.requireNonNull(other, "Gear Value cannot be null") instanceof AbstractGear) {
      AbstractGear gear = (AbstractGear) other;
      return gear.compareToFootwear(this);
    } else {
      return 1;
    }
  }

  @Override
  protected int compareToFootwear(Footwear other) {
    return Objects.requireNonNull(other.getStrength(), "Strength value cannot be null")
        .compareTo(Objects.requireNonNull(this.getStrength(), "Strength value cannot be null"));
  }

}

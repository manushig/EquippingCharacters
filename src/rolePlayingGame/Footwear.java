package rolePlayingGame;

import java.util.Objects;

/**
 * Footwear, these items go on the character’s feet (boots/sneakers) and are
 * only used for attack.
 */
public class Footwear extends AbstractGear {

  /**
   * Constructs a Footwear in terms of its full name, adjective, worn out
   * percentage and strength.
   *
   * @param gearFullName      It is the full name of the foot wear.
   * @param gearAdjectiveName It is the adjective name of the foot wear.
   * @param wornOutPercentage It is the worn out percentage of the foot wear.
   * @param strength          It is the strength of the foot wear.
   * @throws NullPointerException If foot wear Full Name or Adjective Name or Worn
   *                              out percentage or Strength values are null.
   */

  public Footwear(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      IStrength gearAttackStrength) {
    super(Objects.requireNonNull(gearFullName, "Gear Full Name value cannot be null"),
        Objects.requireNonNull(gearAdjectiveName, "Gear Adjective Name value cannot be null"),
        Objects.requireNonNull(wornOutPercentage, "Gear wornout percentage value cannot be null"),
        Objects.requireNonNull(gearAttackStrength, "Gear Attack Strength cannot be null"));
  }

  @Override
  public void accept(GearVisitor visitor) throws NullPointerException {
    if (Objects.isNull(visitor)) {
      throw new NullPointerException("Visitor Value cannot be null");
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

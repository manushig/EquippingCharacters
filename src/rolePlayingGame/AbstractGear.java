package rolePlayingGame;

import java.util.Objects;

/**
 * AbstractGear, It is an abstract base class for implementations of
 * {@link IGear}. This class contains all the method definitions that are common
 * to the concrete implementations of the {@link IGear} interface.
 */
public abstract class AbstractGear implements IGear {
  private final GearDescription gearDescription;
  private final int wornOutPercentage;
  private final IStrength strength;

  /**
   * Constructs a AbstractGear in terms of its full name, adjective, worn out
   * percentage and strength.
   *
   * @param gearFullName      It is the full name of the gear.
   * @param gearAdjectiveName It is the adjective name of the gear.
   * @param wornOutPercentage It is the worn out percentage of the gear.
   * @param strength          It is the strength of the gear.
   * @throws NullPointerException If Gear Full Name or Gear Adjective Name or Worn
   *                              out percentage or Strength values are null.
   */
  public AbstractGear(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      IStrength strength) {
    this.gearDescription = new GearDescription(
        Objects.requireNonNull(gearFullName, "Gear Full Name value cannot be null"),
        Objects.requireNonNull(gearAdjectiveName, "Gear Adjective Name value cannot be null"));
    this.wornOutPercentage = Objects.requireNonNull(wornOutPercentage,
        "Wornout Percentage value cannot be null");
    this.strength = Objects.requireNonNull(strength, "Gear Strength value cannot be null");
  }

  /**
   * Compare the gear with the HeadGear object.
   *
   * @param other the HeadGear object to which this gear must be compared
   * @return 1 by default, subclasses may override
   */
  protected int compareToHeadGear(HeadGear other) {
    return 1;
  }

  /**
   * Compare the gear with the HandGear object.
   *
   * @param other the HandGear object to which this gear must be compared
   * @return 1 by default, subclasses may override
   */
  protected int compareToHandGear(HandGear other) {
    return 1;
  }

  /**
   * Compare the gear with the Footwear object.
   *
   * @param other the Footwear object to which this gear must be compared
   * @return 1 by default, subclasses may override
   */
  protected int compareToFootwear(Footwear other) {
    return 1;
  }

  /**
   * Gets the Gear Description.
   *
   * @return the Gear Description.
   */
  protected GearDescription getGearDescription() {
    GearDescription gearDescriptionCopy = new GearDescription(this.gearDescription);
    return gearDescriptionCopy;
  }

  /**
   * Gets the worn out percentage of the Gear.
   *
   * @return the worn out percentage of the Gear.
   */
  protected int getWornOutPercentage() {
    return this.wornOutPercentage;
  }

  /**
   * Gets the Gear's Strength.
   *
   * @return the IStrength object.
   */
  protected IStrength getStrength() {

    return this.strength;
  }

  @Override
  public String toString() {
    return gearDescription.getItemsFullName();
  }

}

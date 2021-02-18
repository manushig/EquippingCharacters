package rolePlayingGame;

import java.util.Objects;

public abstract class AbstractGear implements IGear {
  private GearDescription gearDescription;
  private int wornOutPercentage;
  private IStrength strength;

  public AbstractGear(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      IStrength strength) {
    this.gearDescription = Objects.requireNonNull(
        new GearDescription(gearFullName, gearAdjectiveName),
        "Gear Full Name value cannot be null");
    this.wornOutPercentage = Objects.requireNonNull(wornOutPercentage,
        "Wornout Percentage value cannot be null");
    this.strength = Objects.requireNonNull(strength, "Gear Strength value cannot be null");
  }

  protected int compareToHeadGear(HeadGear other) {
    return 1;
  }

  protected int compareToHandGear(HandGear other) {
    return 1;
  }

  protected int compareToFootwear(Footwear other) {
    return 1;
  }

  protected GearDescription getGearDescription() {
    return this.gearDescription;
  }

  protected Integer getWornOutPercentage() {
    return this.wornOutPercentage;
  }

  protected IStrength getStrength() {
    return this.strength;
  }

  @Override
  public String toString() {
    return gearDescription.getItemsFullName();
  }

}

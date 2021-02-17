package rolePlayingGame;

public abstract class AbstractGear implements IGear {
  private GearDescription gearDescription;
  private int wornOutPercentage;
  private IStrength strength;

  public AbstractGear(String gearFullName, String gearAdjectiveName, int wornOutPercentage, IStrength strength) {
    this.gearDescription = new GearDescription(gearFullName, gearAdjectiveName);
    this.wornOutPercentage = wornOutPercentage;
    this.strength = strength;
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
  
  

}

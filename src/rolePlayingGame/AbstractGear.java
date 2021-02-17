package rolePlayingGame;

public abstract class AbstractGear implements IGear {
  private GearDescription gearDescription;
  private int wornOutPercentage;
  private Boolean result = false;

  public AbstractGear(String gearFullName, String gearAdjectiveName, int wornOutPercentage) {
    this.gearDescription = new GearDescription(gearFullName, gearAdjectiveName);
    this.wornOutPercentage = wornOutPercentage;
  }

  @Override
  public Boolean getResult() {
    return result;
  }

  protected void setResult(Boolean result) {
    this.result = result;
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

}

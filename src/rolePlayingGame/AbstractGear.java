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

  protected IGear isAllowedHandGear(HandGear gear) {
    this.result = false;
    return this;
  }

  protected IGear isAllowedFootwear(Footwear gear)
  {
    this.result = false;
    return this;
  }

  protected IGear isAllowedHeadGear(HeadGear gear)
  {
    this.result = false;
    return this;
  }

  protected IGear isAllowedJewelry(Jewelry gear)
  {
    this.result = false;
    return this;
  }

}

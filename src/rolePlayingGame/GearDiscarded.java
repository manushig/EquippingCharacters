package rolePlayingGame;

public class GearDiscarded {
  private IGear discardedGear;
  private IGear replacedByGear;
  
  public GearDiscarded(IGear discardedGear, IGear replacedByGear)
  {
    this.discardedGear = discardedGear;
    this.replacedByGear = replacedByGear;
  }

  @Override
  public String toString() {
    return "ItemsDiscarded [discardedGear=" + discardedGear + ", replacedByGear=" + replacedByGear
        + ", toString()=" + super.toString() + "]";
  }

  
}

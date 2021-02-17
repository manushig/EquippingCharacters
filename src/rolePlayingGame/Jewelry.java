package rolePlayingGame;

public class Jewelry extends AbstractGear {

  private IStrength strength;

  private int count = 1;

  public Jewelry(String gearFullName, String gearAdjectiveName, int wornOutPercentage,
      IStrength gearStrength) {
    super(gearFullName, gearAdjectiveName, wornOutPercentage);
    this.strength = gearStrength;
  }

  @Override
  public void accept(GearVisitor visitor) {
    visitor.visit(this);

  }

  @Override
  public int getCount() {
    return count;
  }
  
  
  public IStrength getDefenceStrength() {
    return strength;
  }

  @Override
  public int compareTo(IGear o) {
    return -1;
  }

}

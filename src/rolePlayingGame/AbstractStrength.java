package rolePlayingGame;

public abstract class AbstractStrength implements IStrength {

  private int strength;

  protected AbstractStrength(int strength) {
    this.strength = strength;
  }

  @Override
  public String toString() {
    return String.format(String.valueOf(this.strength));
  }
}

package rolePlayingGame;

public abstract class AbstractStrength implements IStrength {

  private Integer strength;

  protected AbstractStrength(Integer strength) {
    this.strength = strength;
  }

  @Override
  public String toString() {
    return String.format(String.valueOf(this.strength));
  }
  
  protected int compareToAttack(Attack other) {
    return 0;
  }
  
  protected int compareToDefence(Defence other) {
    return -1;
  }

  public Integer getStrength() {
    return strength;
  }
}

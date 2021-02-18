package rolePlayingGame;

import java.util.Objects;

public abstract class AbstractStrength implements IStrength {

  private Integer strength;

  protected AbstractStrength(Integer strength) {
    this.strength = Objects.requireNonNull(strength,"Strength value cannot be null");
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


  protected Integer getStrength() {
    return strength;
  }
}

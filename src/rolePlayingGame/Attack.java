package rolePlayingGame;

import java.util.Objects;

public class Attack extends AbstractStrength {

  public Attack(int attackStrength) {
    super(Objects.requireNonNull(attackStrength, "Attack Strength value cannot be null"));
  }

  @Override
  public int compareTo(IStrength other) throws IllegalArgumentException {
    if (Objects.isNull(other)) {
      throw new IllegalArgumentException("Strength Value cannot be null");
    }
    if (other instanceof AbstractStrength) {
      AbstractStrength strength = (AbstractStrength) other;
      return strength.compareToAttack(this);
    } else {
      return 1;
    }
  }

  @Override
  protected int compareToAttack(Attack other) {
    return other.getStrength().compareTo(this.getStrength());
  }

  @Override
  public void accept(StrengthVisitor visitor) throws IllegalArgumentException {
    if (Objects.isNull(visitor)) {
      throw new IllegalArgumentException("Vsitor Value cannot be null");
    }
    visitor.visit(this);

  }
}

package rolePlayingGame;

import java.util.Objects;

/**
 * Attack, it is the attack value of either gear or the character.
 */
public class Attack extends AbstractStrength {
  /**
   * Constructs a Attack in terms of attack strength.
   *
   * @param attackStrength It is the attack strength.
   * @throws NullPointerException If attack Strength value is null.
   */
  public Attack(int attackStrength) {
    super(Objects.requireNonNull(attackStrength, "Attack Strength value cannot be null"));
  }

  @Override
  public int compareTo(IStrength other) throws NullPointerException {
    if (Objects.isNull(other)) {
      throw new NullPointerException("Strength Value cannot be null");
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
    return Objects.requireNonNull(other.getStrength(), "Strength value cannot be null")
        .compareTo(Objects.requireNonNull(this.getStrength(), "Strength value cannot be null"));
  }

  @Override
  public void accept(StrengthVisitor visitor) throws NullPointerException {
    if (Objects.isNull(visitor)) {
      throw new NullPointerException("Visitor Value cannot be null");
    }
    visitor.visit(this);

  }
}

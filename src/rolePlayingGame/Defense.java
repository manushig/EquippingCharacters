package rolePlayingGame;

import java.util.Objects;

/**
 * Defense, it is the defense value of either gear or the character.
 */
public class Defense extends AbstractStrength {
  /**
   * Constructs a Defense in terms of defense strength.
   *
   * @param attackStrength It is the defense strength.
   * @throws NullPointerException If defense Strength value is null.
   */
  public Defense(int defenceStrength) {
    super(Objects.requireNonNull(defenceStrength, "Defence Strength value cannot be null"));
  }

  @Override
  public int compareTo(IStrength other) throws NullPointerException {
    if (Objects.isNull(other)) {
      throw new NullPointerException("Strength Value cannot be null");
    }
    if (other instanceof AbstractStrength) {
      AbstractStrength strength = (AbstractStrength) other;
      return strength.compareToDefense(this);
    } else {
      return -1;
    }
  }

  @Override
  protected int compareToDefense(Defense other) {
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

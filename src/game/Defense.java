package game;

import java.util.Objects;

/**
 * Defense, it is the defense value of either gear or the character.
 */
public class Defense extends AbstractStrength {
  /**
   * Constructs a Defense in terms of defense strength.
   *
   * @param defenceStrength It is the defense strength.
   */
  public Defense(int defenceStrength) {
    super(Objects.requireNonNull(defenceStrength, "Defence Strength value cannot be null"));
  }

  @Override
  public int compareTo(IStrength other) {
    if (Objects.requireNonNull(other,
        "Strength Value cannot be null") instanceof AbstractStrength) {
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
  public void accept(StrengthVisitor visitor) {
    Objects.requireNonNull(visitor, "Visitor Value cannot be null").visit(this);

  }
}

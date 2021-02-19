package game;

import java.util.Objects;

/**
 * AbstractStrength, It is an abstract base class for implementations of
 * {@link IStrength}. This class contains all the method definitions that are
 * common to the concrete implementations of the {@link IStrength} interface.
 */
public abstract class AbstractStrength implements IStrength {

  private final Integer strength;

  /**
   * Constructs a AbstractStrength in terms of strength.
   *
   * @param strength It is the strength of the gear.
   */
  protected AbstractStrength(Integer strength) {
    this.strength = Objects.requireNonNull(strength, "Strength value cannot be null");
  }

  @Override
  public String toString() {
    return String.format(String.valueOf(this.strength));
  }

  /**
   * Compare the strength with the Attack object.
   *
   * @param other the Attack object to which this strength must be compared
   * @return 0 by default, subclasses may override
   */
  protected int compareToAttack(Attack other) {
    return 0;
  }

  /**
   * Compare the strength with the Defense object.
   *
   * @param other the Defense object to which this strength must be compared
   * @return -1 by default, subclasses may override
   */
  protected int compareToDefense(Defense other) {
    return -1;
  }

  /**
   * Gets the Gear's Strength.
   *
   * @return the IStrength object.
   */
  protected Integer getStrength() {
    return new Integer(this.strength);
  }
}

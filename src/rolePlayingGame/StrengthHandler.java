package rolePlayingGame;

import java.util.Objects;

/**
 * StrengthHandler, manages the attack and defense of character or gear.
 */
public class StrengthHandler implements StrengthVisitor {
  private Integer attackStrengthValue;
  private Integer defenceStrengthValue;

  /**
   * Constructs a StrengthHandler
   *
   */
  public StrengthHandler() {
    this.attackStrengthValue = 0;
    this.defenceStrengthValue = 0;
  }

  @Override
  public void visit(Attack attack) throws NullPointerException {
    if (Objects.isNull(attack)) {
      throw new NullPointerException("Attack value cannot be null");
    }
    attackStrengthValue = Objects.requireNonNull(attack.getStrength(),
        "Attack value cannot be null");
  }

  @Override
  public void visit(Defense defence) throws NullPointerException {
    if (Objects.isNull(defence)) {
      throw new NullPointerException("Defence value cannot be null");
    }
    defenceStrengthValue = Objects.requireNonNull(defence.getStrength(),
        "Defence value cannot be null");
  }

  /**
   * This method gets the attack value.
   * 
   * @return the attack value.
   */
  public Integer getAttackStrengthValue() {
    return new Integer(this.attackStrengthValue);
  }

  /**
   * This method gets the defense value.
   * 
   * @return the defense value.
   */
  public Integer getDefenseStrengthValue() {
    return new Integer(this.defenceStrengthValue);
  }

}

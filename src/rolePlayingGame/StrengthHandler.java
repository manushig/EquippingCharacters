package rolePlayingGame;

import java.util.Objects;

public class StrengthHandler implements StrengthVisitor {
  private Integer attackStrengthValue = 0;
  private Integer defenceStrengthValue = 0;

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

  public Integer getAttackStrengthValue() {
    return this.attackStrengthValue;
  }

  public Integer getDefenceStrengthValue() {
    return this.defenceStrengthValue;
  }

}

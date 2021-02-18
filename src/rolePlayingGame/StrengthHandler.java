package rolePlayingGame;

import java.util.Objects;

public class StrengthHandler implements StrengthVisitor {
  private Integer attackStrengthValue = 0;
  private Integer defenceStrengthValue = 0;

  @Override
  public void visit(Attack attack) throws IllegalArgumentException {
    if (Objects.isNull(attack)) {
      throw new IllegalArgumentException("Attack value cannot be null");
    }
    attackStrengthValue = attack.getStrength();
  }

  @Override
  public void visit(Defence defence) throws IllegalArgumentException {
    if (Objects.isNull(defence)) {
      throw new IllegalArgumentException("Defence value cannot be null");
    }
    defenceStrengthValue = defence.getStrength();
  }

  public Integer getAttackStrengthValue() {
    return this.attackStrengthValue;
  }

  public Integer getDefenceStrengthValue() {
    return this.defenceStrengthValue;
  }

}

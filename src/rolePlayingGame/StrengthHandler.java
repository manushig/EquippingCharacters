package rolePlayingGame;

public class StrengthHandler implements StrengthVisitor{
  private Integer attackStrengthValue = 0;
  private Integer defenceStrengthValue = 0;
  
  @Override
  public void visit(Attack attack) {
    attackStrengthValue = attack.getStrength();    
  }

  @Override
  public void visit(Defence defence) {
    defenceStrengthValue = defence.getStrength(); 
  }

  public Integer getAttackStrengthValue() {
    return this.attackStrengthValue;
  }

  public Integer getDefenceStrengthValue() {
    return this.defenceStrengthValue;
  }

}

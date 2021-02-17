package rolePlayingGame;

public class GearStrengthHandler implements GearVisitor {
  private int totalDefenceValue = 0;
  private int totalAttackValue = 0;
  private Integer currentRound;

  public GearStrengthHandler(int round) {
    this.currentRound = round;
  }

  public int getTotaldefenceValue() {
    return totalDefenceValue;
  }

  public int getTotalattackValue() {
    return totalAttackValue;
  }

  @Override
  public void visit(HeadGear headGear) {
    StrengthHandler strengthHandler = new StrengthHandler();
    headGear.getStrength().accept(strengthHandler);

    int gearDefenceValue = strengthHandler.getDefenceStrengthValue();

    Integer value = gearDefenceValue
        - ((this.currentRound - 1) * ((headGear.getWornOutPercentage() * gearDefenceValue) / 100));
    totalDefenceValue += value;
  }

  @Override
  public void visit(Footwear footwear) {
    StrengthHandler strengthHandler = new StrengthHandler();
    footwear.getStrength().accept(strengthHandler);

    int gearAttackValue = strengthHandler.getAttackStrengthValue();

    Integer value = gearAttackValue
        - ((this.currentRound - 1) * ((footwear.getWornOutPercentage() * gearAttackValue) / 100));
    totalAttackValue += value;
  }

  @Override
  public void visit(HandGear handGear) {
    StrengthHandler strengthHandler = new StrengthHandler();
    handGear.getStrength().accept(strengthHandler);

    int gearDefenceValue = strengthHandler.getDefenceStrengthValue();
    int gearAttackValue = strengthHandler.getAttackStrengthValue();
    Integer value = 0;

    if (gearDefenceValue == 0) {
      value = gearAttackValue
          - ((this.currentRound - 1) * ((handGear.getWornOutPercentage() * gearAttackValue) / 100));
      totalAttackValue += value;
    } else {
      value = gearDefenceValue - ((this.currentRound - 1)
          * ((handGear.getWornOutPercentage() * gearDefenceValue) / 100));
      totalDefenceValue += value;
    }

  }

  @Override
  public void visit(Jewelry jewelry) {
    StrengthHandler strengthHandler = new StrengthHandler();
    jewelry.getStrength().accept(strengthHandler);

    int gearDefenceValue = strengthHandler.getDefenceStrengthValue();
    int gearAttackValue = strengthHandler.getAttackStrengthValue();
    Integer value = 0;

    if (gearDefenceValue == 0) {
      value = gearAttackValue
          - ((this.currentRound - 1) * ((jewelry.getWornOutPercentage() * gearAttackValue) / 100));
      totalAttackValue += value;
    } else {
      value = gearDefenceValue
          - ((this.currentRound - 1) * ((jewelry.getWornOutPercentage() * gearDefenceValue) / 100));
      totalDefenceValue += value;
    }

  }

}

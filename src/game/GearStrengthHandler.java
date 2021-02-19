package game;

import java.util.Objects;

/**
 * GearStrengthHandler, calculate the gear strength considering wear out
 * percentage in the given round.
 * <ul>
 * <li>Some items wear out with each use and thus their benefit decreases each
 * time a player uses them.
 * </ul>
 */
public class GearStrengthHandler implements GearVisitor {
  private int totalDefenceValue;
  private int totalAttackValue;
  private final int currentRound;

  /**
   * Constructs a GearStrengthHandler in terms of round.
   *
   * @param round It is the round where players are currently battling.
   * @throws NullPointerException     If round value is null
   * @throws IllegalArgumentException if round value is 0
   */
  public GearStrengthHandler(int round) throws IllegalArgumentException {
    if (round == 0) {
      throw new IllegalArgumentException("Round value cannot be zero");
    }
    this.currentRound = Objects.requireNonNull(round, "Round value cannnot be null");
    this.totalDefenceValue = 0;
    this.totalAttackValue = 0;
  }

  /**
   * This method gets the gear's total defense value.
   * 
   * @return the gear's total defense value.
   */
  public int getTotaldefenseValue() {
    return totalDefenceValue;
  }

  /**
   * This method gets the gear's total attack value.
   * 
   * @return the gear's total attack value.
   */
  public int getTotalattackValue() {
    return totalAttackValue;
  }

  @Override
  public void visit(HeadGear headGear) throws IllegalArgumentException {
    if (Objects.isNull(headGear)) {
      throw new IllegalArgumentException("Head Gear value cannot be null");
    }
    StrengthHandler strengthHandler = new StrengthHandler();
    headGear.getStrength().accept(strengthHandler);

    int gearDefenceValue = strengthHandler.getDefenseStrengthValue();

    Integer value = gearDefenceValue
        - ((this.currentRound - 1) * ((headGear.getWornOutPercentage() * gearDefenceValue) / 100));
    totalDefenceValue += value;
  }

  @Override
  public void visit(Footwear footwear) throws IllegalArgumentException {
    if (Objects.isNull(footwear)) {
      throw new IllegalArgumentException("Footwear value cannot be null");
    }
    StrengthHandler strengthHandler = new StrengthHandler();
    footwear.getStrength().accept(strengthHandler);

    int gearAttackValue = strengthHandler.getAttackStrengthValue();

    Integer value = gearAttackValue
        - ((this.currentRound - 1) * ((footwear.getWornOutPercentage() * gearAttackValue) / 100));
    totalAttackValue += value;
  }

  @Override
  public void visit(HandGear handGear) throws IllegalArgumentException {
    if (Objects.isNull(handGear)) {
      throw new IllegalArgumentException("Hand Gear value cannot be null");
    }
    StrengthHandler strengthHandler = new StrengthHandler();
    handGear.getStrength().accept(strengthHandler);

    int gearDefenceValue = strengthHandler.getDefenseStrengthValue();
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
  public void visit(Jewelry jewelry) throws IllegalArgumentException {
    if (Objects.isNull(jewelry)) {
      throw new IllegalArgumentException("Jewellry value cannot be null");
    }
    StrengthHandler strengthHandler = new StrengthHandler();
    jewelry.getStrength().accept(strengthHandler);

    int gearDefenceValue = strengthHandler.getDefenseStrengthValue();
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

package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import javafx.util.Pair;

/**
 * Character, characters will be able to enhance their basic abilities by
 * "wearing" different items.
 */
public class Character implements ICharacter {
  private final int characterHitPoints;
  private final String characterName;
  private final IStrength characterAttackStrength;
  private final IStrength characterDefenseStrength;
  private List<IGear> itemsCurrentlyWearingList;

  /**
   * Constructs a Character in terms of its name, attack and defense strengths.
   *
   * @param characterName         It is the Character Name.
   * @param characterAttackPower  It is the Character Attack Strength.
   * @param characterDefencePower It is the Character Defense Strength.
   * @throws NullPointerException If Character Name, Attack and Defense strength
   *                              values are null.
   */
  public Character(String characterName, int characterAttackPower, int characterDefencePower,
      int characterHitPoints) {
    this.characterName = Objects.requireNonNull(characterName, "Character Name cannot be null");
    this.characterAttackStrength = new Attack(characterAttackPower);
    this.characterDefenseStrength = new Defense(characterDefencePower);
    this.characterHitPoints = characterHitPoints;
    this.itemsCurrentlyWearingList = new ArrayList<IGear>();
  }

  @Override
  public String dressUpGear(IGear gear) throws IllegalArgumentException {
    if (Objects.isNull(gear)) {
      throw new IllegalArgumentException("Gear value cannot be null");
    }
    CountGearHandler countGearHandler = new CountGearHandler();
    int currentHeadGearCount = 0;
    int currentHandGearCount = 0;
    int currentFootWearCount = 0;
    String gearDressedUpResult = "";

    for (IGear item : itemsCurrentlyWearingList) {
      item.accept(countGearHandler);
    }

    currentHeadGearCount = countGearHandler.getHeadGearCount();
    currentFootWearCount = countGearHandler.getFootwearCount();
    currentHandGearCount = countGearHandler.getHandGearCount();

    GearAllowedHandler isGearAllowedHandler = new GearAllowedHandler(currentHeadGearCount,
        currentHandGearCount, currentFootWearCount);
    gear.accept(isGearAllowedHandler);

    if (Objects.requireNonNull(isGearAllowedHandler.getIsAllowed(),
        "IsGearAllowed value cannot be null")) {
      this.itemsCurrentlyWearingList.add(gear);
      gearDressedUpResult = String.format("%s wore %s", this.characterName, gear.toString());

    } else {
      Collections.sort(this.itemsCurrentlyWearingList);

      IGear discardedGear = null;
      for (IGear existingItem : this.itemsCurrentlyWearingList) {
        int result = existingItem.compareTo(gear);
        if (result < 0) {

          discardedGear = existingItem;
          gearDressedUpResult = String.format("%s discarded %s replaced by %s", this.characterName,
              existingItem.toString(), gear.toString());
          break;
        }
      }
      if (Objects.isNull(discardedGear)) {
        gearDressedUpResult = String.format("%s discarded %s", this.characterName, gear.toString());
      } else {
        ListIterator<IGear> iterator = this.itemsCurrentlyWearingList.listIterator();
        while (iterator.hasNext()) {
          IGear nextGear = iterator.next();
          if (nextGear.equals(discardedGear)) {
            iterator.set(gear);
            break;
          }
        }
      }
    }
    return gearDressedUpResult;
  }

  @Override
  public String getCharacterDetails() {

    StringBuilder characterDescription = new StringBuilder();

    String characterWearing = getCharacterWearing();
    String strength = getStrength();

    characterDescription.append(
        "********************Character " + this.characterName + " Details********************\n\n");
    characterDescription.append("Name: " + this.characterName + "\n");
    characterDescription.append("\n" + characterWearing);
    characterDescription.append("\n" + strength);

    return characterDescription.toString();
  }

  /**
   * Private Helper method to print total Strength of the character.
   *
   * @return String to print total Strength of the character
   */
  private String getStrength() {
    StringBuilder strength = new StringBuilder();
    int totalAttackStrength = 0;
    int totalDefenceStrength = 0;

    Pair<Integer, Integer> totalStrength = getTotalStrengthValues(1);

    totalAttackStrength = totalStrength.getKey();
    totalDefenceStrength = totalStrength.getValue();

    strength.append("Attack Strength: " + totalAttackStrength + "\n");
    strength.append("Defence Strength: " + totalDefenceStrength + "\n");

    return strength.toString();
  }

  /**
   * Private Helper method to print what character is wearing.
   *
   * @return String to print what character is wearing
   */
  private String getCharacterWearing() {
    CharacterWearingHandler characterWearingHandler = new CharacterWearingHandler();
    StringBuilder characterWearing = new StringBuilder();
    String headGearDescription = "";
    String footWearDescription = "";
    String handGearDescription = "";
    String jewelryDescription = "";

    for (IGear item : itemsCurrentlyWearingList) {
      item.accept(characterWearingHandler);
    }
    headGearDescription = Objects.requireNonNull(characterWearingHandler.getHeadGearDescription(),
        "Head Gear Description value cannot be null");
    footWearDescription = Objects.requireNonNull(characterWearingHandler.getFootWearDescription(),
        "Footwear Description value cannot be null");
    handGearDescription = Objects.requireNonNull(characterWearingHandler.getHandGearDescription(),
        "Hand Gear Description value cannot be null");
    jewelryDescription = Objects.requireNonNull(characterWearingHandler.getJewelryDescription(),
        "Jewellry Description value cannot be null");

    if (!headGearDescription.equals("")) {
      headGearDescription = String.format(headGearDescription + "\n");
    }

    if (!handGearDescription.equals("")) {
      if (handGearDescription.lastIndexOf(",") != -1) {
        StringBuilder removeLastCommaFromHandGear = new StringBuilder(handGearDescription);
        removeLastCommaFromHandGear.replace(handGearDescription.lastIndexOf(","),
            handGearDescription.lastIndexOf(",") + 1, " and");
        handGearDescription = String.format(removeLastCommaFromHandGear.toString() + "\n");
      } else {
        handGearDescription = String.format(handGearDescription + "\n");
      }
    }

    if (!footWearDescription.equals("")) {
      if (footWearDescription.lastIndexOf(",") != -1) {
        StringBuilder removeLastCommaFromFootwear = new StringBuilder(footWearDescription);
        removeLastCommaFromFootwear.replace(footWearDescription.lastIndexOf(","),
            footWearDescription.lastIndexOf(",") + 1, " and");
        footWearDescription = String.format(removeLastCommaFromFootwear.toString() + "\n");
      } else {
        footWearDescription = String.format(footWearDescription + "\n");
      }
    }

    if (!jewelryDescription.equals("")) {
      if (jewelryDescription.lastIndexOf(",") != -1) {
        StringBuilder removeLastCommaFromJewelry = new StringBuilder(jewelryDescription);
        removeLastCommaFromJewelry.replace(jewelryDescription.lastIndexOf(","),
            jewelryDescription.lastIndexOf(",") + 1, " and");
        jewelryDescription = String.format(removeLastCommaFromJewelry.toString() + "\n");
      } else {
        jewelryDescription = String.format(jewelryDescription + "\n");
      }
    }

    characterWearing.append(headGearDescription);
    characterWearing.append(footWearDescription);
    characterWearing.append(handGearDescription);
    characterWearing.append(jewelryDescription);

    return characterWearing.toString();
  }

  /**
   * Private Helper method to get total character hit points which include
   * Character Attack Value and Character Defense Value.
   *
   * @return total character hit points which include Character Attack Value and
   *         Character Defense Value.
   */
  private Pair<Integer, Integer> getTotalStrengthValues(int round) {

    GearStrengthHandler gearStrengthHandler = new GearStrengthHandler(round);

    int gearTotalAttackStrength = 0;
    int gearTotalDefenceStrength = 0;
    int totalAttackStrength = 0;
    int totalDefenceStrength = 0;
    Pair<Integer, Integer> gearTotalStrength;

    for (IGear item : itemsCurrentlyWearingList) {

      item.accept(gearStrengthHandler);
    }

    gearTotalAttackStrength = Objects.requireNonNull(gearStrengthHandler.getTotalattackValue(),
        "Total Attack value cannot be null");
    gearTotalDefenceStrength = Objects.requireNonNull(gearStrengthHandler.getTotaldefenseValue(),
        "Total Defence value cannot be null");

    StrengthHandler strengthHandler = new StrengthHandler();
    this.characterAttackStrength.accept(strengthHandler);
    this.characterDefenseStrength.accept(strengthHandler);

    totalAttackStrength = Objects.requireNonNull(strengthHandler.getAttackStrengthValue(),
        "Attack Strength value cannot be null") + gearTotalAttackStrength;
    totalDefenceStrength = Objects.requireNonNull(strengthHandler.getDefenseStrengthValue(),
        "Defence Strength value cannot be null") + gearTotalDefenceStrength;

    gearTotalStrength = new Pair<>(totalAttackStrength, totalDefenceStrength);
    return gearTotalStrength;
  }

  @Override
  public Pair<Integer, Integer> characterTotalStrength(int round) throws IllegalArgumentException {

    if ((Objects.isNull(round)) || (round == 0)) {
      throw new IllegalArgumentException("Round value cannot be 0 or null");
    }

    return getTotalStrengthValues(round);
  }

  @Override
  public String toString() {
    return this.characterName;
  }
}

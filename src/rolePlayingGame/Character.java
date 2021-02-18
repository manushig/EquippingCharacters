package rolePlayingGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import javafx.util.Pair;

public class Character implements ICharacter {
  private String characterName;
  private IStrength characterAttackPower;
  private IStrength characterDefencePower;
  private int currentHeadGearCount;
  private int currentHandGearCount;
  private int currentFootWearCount;
  private List<IGear> itemsCurrentlyWearingList;
  private List<GearDiscarded> itemsDiscardedList;

  public Character(String characterName, int characterAttackPower, int characterDefencePower) {
    this.characterName = Objects.requireNonNull(characterName, "Character Name cannot be null");
    this.characterAttackPower = new Attack(
        Objects.requireNonNull(characterAttackPower, "Character Attack Power cannot be null"));
    this.characterDefencePower = new Defence(
        Objects.requireNonNull(characterDefencePower, "Character Defence Power cannot be null"));
    this.itemsCurrentlyWearingList = new ArrayList<IGear>();
    this.itemsDiscardedList = new ArrayList<GearDiscarded>();
    this.currentHandGearCount = 0;
    this.currentFootWearCount = 0;
    this.currentHeadGearCount = 0;
  }

  @Override
  public ICharacter dressUpGear(IGear gear) throws IllegalArgumentException {
    if (Objects.isNull(gear)) {
      throw new IllegalArgumentException("Gear value cannot be null");
    }
    CountGearHandler countGearHandler = new CountGearHandler();

    for (IGear item : itemsCurrentlyWearingList) {
      item.accept(countGearHandler);
    }

    this.currentHeadGearCount = countGearHandler.getHeadGearCount();
    this.currentFootWearCount = countGearHandler.getFootwearCount();
    this.currentHandGearCount = countGearHandler.getHandGearCount();

    GearAllowedHandler isGearAllowedHandler = new GearAllowedHandler(this.currentHeadGearCount,
        this.currentHandGearCount, this.currentFootWearCount);
    gear.accept(isGearAllowedHandler);

    if (isGearAllowedHandler.getIsAllowed()) {
      this.itemsCurrentlyWearingList.add(gear);
    } else {
      Collections.sort(this.itemsCurrentlyWearingList);
      GearDiscarded gearToDiscard = null;
      IGear discardedGear = null;
      for (IGear existingItem : this.itemsCurrentlyWearingList) {
        int result = existingItem.compareTo(gear);
        if (result < 0) {
          gearToDiscard = new GearDiscarded(existingItem, gear);
          discardedGear = existingItem;
          break;
        }
      }
      if (Objects.isNull(gearToDiscard)) {
        gearToDiscard = new GearDiscarded(gear, null);
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

      this.itemsDiscardedList.add(gearToDiscard);
    }
    return this;
  }

  @Override
  public String printCharacterDetails() {

    StringBuilder characterDescription = new StringBuilder();

    String characterWearing = getCharacterWearing();
    String strength = getStrength();
    String discaredItemList = getDiscaredItemsList();

    characterDescription.append(
        "********************Character " + this.characterName + " Details********************\n\n");
    characterDescription.append("Name: " + this.characterName + "\n");
    characterDescription.append("\n" + characterWearing);
    characterDescription.append("\n" + strength);
    characterDescription.append("\n" + discaredItemList);

    return characterDescription.toString();
  }

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
    headGearDescription = characterWearingHandler.getHeadGearDescription();
    footWearDescription = characterWearingHandler.getFootWearDescription();
    handGearDescription = characterWearingHandler.getHandGearDescription();
    jewelryDescription = characterWearingHandler.getJewelryDescription();

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

  private String getDiscaredItemsList() {
    StringBuilder stringBuilder = new StringBuilder();

    if (this.itemsDiscardedList.size() > 0) {
      stringBuilder.append("Discared Item List:\n");
    }
    for (GearDiscarded item : itemsDiscardedList) {
      stringBuilder.append("- " + item.toString() + "\n");
    }

    return stringBuilder.toString();
  }

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

    gearTotalAttackStrength = gearStrengthHandler.getTotalattackValue();
    gearTotalDefenceStrength = gearStrengthHandler.getTotaldefenceValue();

    StrengthHandler strengthHandler = new StrengthHandler();
    this.characterAttackPower.accept(strengthHandler);
    this.characterDefencePower.accept(strengthHandler);

    totalAttackStrength = strengthHandler.getAttackStrengthValue() + gearTotalAttackStrength;
    totalDefenceStrength = strengthHandler.getDefenceStrengthValue() + gearTotalDefenceStrength;

    gearTotalStrength = new Pair<>(totalAttackStrength, totalDefenceStrength);
    return gearTotalStrength;
  }

  @Override
  public Pair<Integer, Integer> characterHitPoints(int round) throws IllegalArgumentException {
    if (Objects.isNull(round)) {
      throw new IllegalArgumentException("Round value cannot be null");
    }
    if (round == 0) {
      throw new IllegalArgumentException("Round value cannot be 0");
    }

    return getTotalStrengthValues(round);
  }

  @Override
  public String toString() {
    return this.characterName;
  }
}

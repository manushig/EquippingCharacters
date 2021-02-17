package rolePlayingGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class Character implements ICharacter {
  private String characterName;
  private int currentHitPoints;
  private IStrength characterAttackPower;
  private IStrength characterDefencePower;
  private int currentHeadGearCount;
  private int currentHandGearCount;
  private int currentFootWearCount;
  private int currentJewelryCount;
  private List<IGear> itemsCurrentlyWearingList;
  private List<GearDiscarded> itemsDiscardedList;

  public Character(String characterName, int hitPoints, int characterAttackPower,
      int characterDefencePower) {
    this.characterName = characterName;
    this.currentHitPoints = hitPoints;
    this.characterAttackPower = new Attack(characterAttackPower);
    this.characterDefencePower = new Defence(characterDefencePower);
    this.itemsCurrentlyWearingList = new ArrayList<IGear>();
    this.itemsDiscardedList = new ArrayList<GearDiscarded>();
    this.currentHandGearCount = 0;
    this.currentFootWearCount = 0;
    this.currentHeadGearCount = 0;
    this.currentJewelryCount = 0;
  }

  @Override
  public ICharacter dressUpGear(IGear gear) {
    CountGearHandler countGearHandler = new CountGearHandler();

    for (IGear item : itemsCurrentlyWearingList) {
      item.accept(countGearHandler);
    }

    this.currentHeadGearCount = countGearHandler.getHeadGearCount();
    this.currentFootWearCount = countGearHandler.getFootwearCount();
    this.currentHandGearCount = countGearHandler.getHandGearCount();
    this.currentJewelryCount = countGearHandler.getJewelryCount();

    GearAllowedHandler isGearAllowedHandler = new GearAllowedHandler(this.currentHeadGearCount,
        this.currentHandGearCount, this.currentFootWearCount, this.currentJewelryCount);
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

    characterDescription.append("Character Name: " + this.characterName + "\n");
    characterDescription.append(characterWearing);
    characterDescription.append(strength);

    return characterDescription.toString();
  }

  private String getStrength() {
    StringBuilder strength = new StringBuilder();
    GearStrengthHandler gearStrengthHandler = new GearStrengthHandler(1);

    int gearTotalAttackStrenth = 0;
    int gearTotalDefenceStrenth = 0;
    int TotalAttackStrength = 0;
    int TotalDefenceStrength = 0;

    for (IGear item : itemsCurrentlyWearingList) {

      item.accept(gearStrengthHandler);
    }

    gearTotalAttackStrenth = gearStrengthHandler.getTotalattackValue();
    gearTotalDefenceStrenth = gearStrengthHandler.getTotaldefenceValue();

    StrengthHandler strengthHandler = new StrengthHandler();
    this.characterAttackPower.accept(strengthHandler);
    this.characterDefencePower.accept(strengthHandler);

    TotalAttackStrength = strengthHandler.getAttackStrengthValue() + gearTotalAttackStrenth;
    TotalDefenceStrength = strengthHandler.getDefenceStrengthValue() + gearTotalDefenceStrenth;

    strength.append("Attack Strength: " + TotalAttackStrength + "\n");
    strength.append("Defence Strength: " + TotalDefenceStrength + "\n");
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

    StringBuilder removeLastCommaFromHandGear = new StringBuilder(handGearDescription);
    removeLastCommaFromHandGear.replace(handGearDescription.lastIndexOf(","),
        handGearDescription.lastIndexOf(",") + 1, " and");
    handGearDescription = removeLastCommaFromHandGear.toString();

    StringBuilder removeLastCommaFromFootwear = new StringBuilder(footWearDescription);
    removeLastCommaFromFootwear.replace(footWearDescription.lastIndexOf(","),
        footWearDescription.lastIndexOf(",") + 1, " and");
    footWearDescription = removeLastCommaFromFootwear.toString();

    StringBuilder removeLastCommaFromJewelry = new StringBuilder(jewelryDescription);
    removeLastCommaFromJewelry.replace(jewelryDescription.lastIndexOf(","),
        jewelryDescription.lastIndexOf(",") + 1, " and");
    jewelryDescription = removeLastCommaFromJewelry.toString();

    characterWearing.append(headGearDescription + "\n");
    characterWearing.append(footWearDescription + "\n");
    characterWearing.append(handGearDescription + "\n");
    characterWearing.append(jewelryDescription + "\n");

    return characterWearing.toString();
  }
}

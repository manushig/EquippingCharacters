package rolePlayingGame;

import java.util.ArrayList;
import java.util.List;

public class Character implements ICharacter {

  private int currentHitPoints;
  private IStrength characterAttackPower;
  private IStrength characterDefencePower;
  private int maxNoOfHeadGearAllowed = 1;
  private int maxNoOfHandGearAllowed = 2;
  private int maxNoOfFootWearAllowed = 10;
  private int currentHeadGearCount;
  private int currentHandGearCount;
  private int currentFootWearCount;
  private int currentJewelryCount;
  private List<IGear> itemsCurrentlyWearingList;
  private List<IGear> itemsDiscardedList;

  public Character(int hitPoints, int characterAttackPower, int characterDefencePower) {
    this.currentHitPoints = hitPoints;
    this.characterAttackPower = new Attack(characterAttackPower);
    this.characterAttackPower = new Defence(characterDefencePower);
    this.itemsCurrentlyWearingList = new ArrayList<IGear>();
    this.itemsDiscardedList = new ArrayList<IGear>();
    this.currentHandGearCount = 0;
    this.currentFootWearCount = 0;
    this.currentHeadGearCount = 0;
    this.currentJewelryCount = 0;
  }

  @Override
  public ICharacter addGear(IGear gear) {
    CountGearHandler countGearHandler = new CountGearHandler();

    for (IGear item : itemsCurrentlyWearingList) {
      item.accept(countGearHandler);
    }

    this.currentHeadGearCount = countGearHandler.getHeadGearCount();
    this.currentFootWearCount = countGearHandler.getFootwearCount();
    this.currentHandGearCount = countGearHandler.getHandGearCount();
    this.currentJewelryCount = countGearHandler.getJewelryCount();

    GearAllowedHandler isGearAllowedHandler = new GearAllowedHandler(this.currentHeadGearCount, this.currentHandGearCount, this.currentFootWearCount, this.currentJewelryCount);
    gear.accept(isGearAllowedHandler);

    if (isGearAllowedHandler.getIsAllowed()) {
      this.itemsCurrentlyWearingList.add(gear);
    } else {
      this.itemsDiscardedList.add(gear);
    }
    return this;
  }
}

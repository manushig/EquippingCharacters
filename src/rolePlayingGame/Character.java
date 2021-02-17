package rolePlayingGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class Character implements ICharacter {

  private int currentHitPoints;
  private IStrength characterAttackPower;
  private IStrength characterDefencePower;
  private int currentHeadGearCount;
  private int currentHandGearCount;
  private int currentFootWearCount;
  private int currentJewelryCount;
  private List<IGear> itemsCurrentlyWearingList;
  private List<GearDiscarded> itemsDiscardedList;

  public Character(int hitPoints, int characterAttackPower, int characterDefencePower) {
    this.currentHitPoints = hitPoints;
    this.characterAttackPower = new Attack(characterAttackPower);
    this.characterAttackPower = new Defence(characterDefencePower);
    this.itemsCurrentlyWearingList = new ArrayList<IGear>();
    this.itemsDiscardedList = new ArrayList<GearDiscarded>();
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
}

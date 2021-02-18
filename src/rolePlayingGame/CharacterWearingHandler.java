package rolePlayingGame;

import java.util.Objects;

public class CharacterWearingHandler implements GearVisitor {

  String headGearDescription = "";
  String handGearDescription = "";
  String footWearDescription = "";
  String jewelryDescription = "";

  @Override
  public void visit(HeadGear headGear) throws IllegalArgumentException {
    if (Objects.isNull(headGear)) {
      throw new IllegalArgumentException("Head Gear value cannot be null");
    }
    if (headGearDescription.equals("")) {
      headGearDescription = String.format("Head Gear : %s",
          headGear.getGearDescription().getItemsFullName());
    } else {
      headGearDescription = String.format("%s, %s", headGearDescription,
          headGear.getGearDescription().getItemsAdjective());
    }

  }

  @Override
  public void visit(Footwear footwear) throws IllegalArgumentException {
    if (Objects.isNull(footwear)) {
      throw new IllegalArgumentException("Footwear value cannot be null");
    }
    if (footWearDescription.equals("")) {
      footWearDescription = String.format("Footwear : %s",
          footwear.getGearDescription().getItemsFullName());
    } else {
      footWearDescription = String.format("%s, %s", footWearDescription,
          footwear.getGearDescription().getItemsAdjective());
    }
  }

  @Override
  public void visit(HandGear handGear) throws IllegalArgumentException {
    if (Objects.isNull(handGear)) {
      throw new IllegalArgumentException("Hand Gear value cannot be null");
    }
    if (handGearDescription.equals("")) {
      handGearDescription = String.format("Hand Gear : %s",
          handGear.getGearDescription().getItemsFullName());
    } else {
      handGearDescription = String.format("%s, %s", handGearDescription,
          handGear.getGearDescription().getItemsAdjective());
    }
  }

  @Override
  public void visit(Jewelry jewelry) throws IllegalArgumentException {
    if (Objects.isNull(jewelry)) {
      throw new IllegalArgumentException("Jewellry value cannot be null");
    }
    if (jewelryDescription.equals("")) {
      jewelryDescription = String.format("Jewelry : %s",
          jewelry.getGearDescription().getItemsFullName());
    } else {
      jewelryDescription = String.format("%s, %s", jewelryDescription,
          jewelry.getGearDescription().getItemsAdjective());
    }
  }

  public String getHeadGearDescription() {
    return this.headGearDescription;
  }

  public String getFootWearDescription() {
    return this.footWearDescription;
  }

  public String getHandGearDescription() {
    return this.handGearDescription;
  }

  public String getJewelryDescription() {
    return this.jewelryDescription;
  }

}

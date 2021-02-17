package rolePlayingGame;

public class CharacterWearingHandler implements GearVisitor {

  String headGearDescription = "";
  String handGearDescription = "";
  String footWearDescription = "";
  String jewelryDescription = "";

  @Override
  public void visit(HeadGear headGear) {
    if (headGearDescription.equals("")) {
      headGearDescription = String.format("Head Gear : %s",
          headGear.getGearDescription().getItemsFullName());
    } else {
      headGearDescription = String.format("%s, %s", headGearDescription,
          headGear.getGearDescription().getItemsAdjective());
    }

  }

  @Override
  public void visit(Footwear footwear) {
    if (footWearDescription.equals("")) {
      footWearDescription = String.format("Footwear : %s",
          footwear.getGearDescription().getItemsFullName());
    } else {
      footWearDescription = String.format("%s, %s", footWearDescription,
          footwear.getGearDescription().getItemsAdjective());
    }
  }

  @Override
  public void visit(HandGear handGear) {
    if (handGearDescription.equals("")) {
      handGearDescription = String.format("Hand Gear : %s",
          handGear.getGearDescription().getItemsFullName());
    } else {
      handGearDescription = String.format("%s, %s", handGearDescription,
          handGear.getGearDescription().getItemsAdjective());
    }
  }

  @Override
  public void visit(Jewelry jewelry) {
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

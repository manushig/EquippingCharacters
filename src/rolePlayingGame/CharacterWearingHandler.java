package rolePlayingGame;

import java.util.Objects;

/**
 * CharacterWearingHandler, manages the description representation of different
 * types of gears character is wearing.
 * <ul>
 * <li>When describing what a character is wearing, the names of items of the
 * same type are combined. The new grammatically correct name is the full name
 * of the first item, and the adjective of the others.
 * </ul>
 */

public class CharacterWearingHandler implements GearVisitor {

  String headGearDescription;
  String handGearDescription;
  String footWearDescription;
  String jewelryDescription;

  /**
   * Constructs a CharacterWearingHandler
   *
   */
  public CharacterWearingHandler() {
    this.headGearDescription = "";
    this.handGearDescription = "";
    this.footWearDescription = "";
    this.jewelryDescription = "";
  }

  @Override
  public void visit(HeadGear headGear) throws NullPointerException {
    if (Objects.isNull(headGear)) {
      throw new NullPointerException("Head Gear value cannot be null");
    }
    if (headGearDescription.equals("")) {
      headGearDescription = String.format("Head Gear : %s",
          headGear.getGearDescription().getItemsFullName());
    }
  }

  @Override
  public void visit(Footwear footwear) throws NullPointerException {
    if (Objects.isNull(footwear)) {
      throw new NullPointerException("Footwear value cannot be null");
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
  public void visit(HandGear handGear) throws NullPointerException {
    if (Objects.isNull(handGear)) {
      throw new NullPointerException("Hand Gear value cannot be null");
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
  public void visit(Jewelry jewelry) throws NullPointerException {
    if (Objects.isNull(jewelry)) {
      throw new NullPointerException("Jewellry value cannot be null");
    }
    if (jewelryDescription.equals("")) {
      jewelryDescription = String.format("Jewelry : %s",
          jewelry.getGearDescription().getItemsFullName());
    } else {
      jewelryDescription = String.format("%s, %s", jewelryDescription,
          jewelry.getGearDescription().getItemsAdjective());
    }
  }

  /**
   * This method gets the head gear description.
   * 
   * @return the head gear description.
   */
  public String getHeadGearDescription() {
    return this.headGearDescription;
  }

  /**
   * This method gets the foot wear description.
   * 
   * @return the foot wear description.
   */

  public String getFootWearDescription() {
    return this.footWearDescription;
  }

  /**
   * This method gets the hand gear description.
   * 
   * @return the hand gear description.
   */
  public String getHandGearDescription() {
    return this.handGearDescription;
  }

  /**
   * This method gets the Jewelry description.
   * 
   * @return the Jewelry description.
   */
  public String getJewelryDescription() {
    return this.jewelryDescription;
  }

}

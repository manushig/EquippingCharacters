import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import game.Attack;
import game.Character;
import game.CharacterWearingHandler;
import game.CountGearHandler;
import game.Defense;
import game.Footwear;
import game.GearAllowedHandler;
import game.GearStrengthHandler;
import game.HandGear;
import game.HeadGear;
import game.ICharacter;
import game.IGear;
import game.Jewelry;
import javafx.util.Pair;

/**
 * A JUnit test class for the ICharacter.
 */
public class CharacterTest {

  private static IGear helmet;
  private static IGear headband;
  private static IGear cap;
  private static IGear sandal;
  private static IGear boot;
  private static IGear hoverboard;
  private static IGear ring;
  private static IGear signet;
  private static IGear knuckleDuster;
  private static IGear glove;
  private static IGear bracer;
  private static IGear brassKnuckles;
  private static IGear watch;
  private static IGear bangles;
  private static IGear bracelets;
  private static IGear handcuffs;
  private static IGear fingerlessGloves;
  private static IGear wristBand;
  private static IGear amulet;
  private static IGear necklace;
  private static IGear scarab;
  private static IGear collar;
  private static IGear brooch;
  private static IGear ribbon;
  private static IGear bowTie;
  private static IGear pendant;
  private static IGear chain;
  private static IGear choker;
  private static IGear tie;
  private static IGear carcanet;
  private static IGear torc;
  private static IGear cowl;
  private static ICharacter alice;
  private static ICharacter bob;

  @Before
  public void setUp() {
    helmet = new HeadGear("Helmet of Strength", "Strength", 20, new Defense(10));
    headband = new HeadGear("Headband of Shock", "Shock", 40, new Defense(15));
    cap = new HeadGear("Cap of Electricity", "Electricity", 0, new Defense(-1));

    sandal = new Footwear("Sandals of Speed", "Speed", 20, new Attack(10));
    boot = new Footwear("Boots of Momentum", "Momentum", 20, new Attack(6));
    hoverboard = new Footwear("Hoverboard of Heft", "Heft", 40, new Attack(8));

    ring = new HandGear("Ring of Invisibility", "Invisibility", 0, new Attack(-5));
    signet = new HandGear("Signet of Ambush", "Ambush", 25, new Attack(5));
    knuckleDuster = new HandGear("Knuckle Duster of Charge", "Charge", 40, new Attack(3));
    glove = new HandGear("Gloves of Holding", "Holding", 40, new Defense(5));
    bracer = new HandGear("Bracer of Storm", "Storm", 50, new Defense(15));
    brassKnuckles = new HandGear("Brass Knuckles of Shock", "Shock", 0, new Defense(-5));
    watch = new HandGear("Watch of Explosion", "Explosion", 80, new Defense(25));
    bangles = new HandGear("Bangles of Telepathy", "Telepathy", 20, new Defense(10));
    bracelets = new HandGear("Bracelets of Flame", "Flame", 20, new Attack(8));
    handcuffs = new HandGear("Handcuffs of Passion", "Passion", 10, new Defense(2));
    fingerlessGloves = new HandGear("Fingerless Gloves of Rain", "Rain", 0, new Defense(20));
    wristBand = new HandGear("WristBand of Persuasion", "Persuasion", 40, new Attack(2));

    amulet = new Jewelry("Amulet of Electricity", "Electricity", 0, new Attack(-5));
    necklace = new Jewelry("Necklace of Sight", "Sight", 20, new Attack(10));
    scarab = new Jewelry("Scarab of Burning", "Burning", 30, new Attack(5));
    collar = new Jewelry("Collar of Teleportation", "Teleportation", 40, new Attack(15));
    brooch = new Jewelry("Brooch of Ice", "Ice", 0, new Defense(-5));
    ribbon = new Jewelry("Ribbon of Magic", "Magic", 60, new Defense(15));
    bowTie = new Jewelry("BowTie of Escape", "Escape", 50, new Defense(5));
    pendant = new Jewelry("Pendant of Ruin", "Ruin", 10, new Defense(5));
    chain = new Jewelry("Chain of Telepathy", "Telepathy", 20, new Defense(5));
    choker = new Jewelry("Choker of Flight", "Flight", 10, new Defense(11));
    tie = new Jewelry("Tie of Healing", "Healing", 30, new Attack(9));
    carcanet = new Jewelry("Carcanet of Sleep", "Sleep", 20, new Defense(15));
    torc = new Jewelry("Torc of Flame", "Flame", 0, new Attack(-5));
    cowl = new Jewelry("Cowl of Explosion", "Explosion", 40, new Defense(25));
    alice = new Character("Alice", 10, 20);
    bob = new Character("Bob", 10, 20);

  }

  /**
   * Test Character created correctly.
   */

  @Test
  public void testHeadGearCreatedCorrectly() {
    assertEquals("Alice", alice.toString());
  }

  /**
   * Test Character passing Character Name as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testJewelryWithAdjectiveNameAsNull() {
    alice = new Character(null, 10, 20);
  }

  /**
   * Test dressUp Characters with Gear and then print the character details.
   */

  @Test
  public void dressUpCharacterWithGears() {
    // Add 1 HeadGear, 2 FootWear, 10 HandGears and 13 Jewelry
    assertEquals(false, Objects.isNull(alice.dressUpGear(helmet)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(boot)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(sandal)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(handcuffs)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(ring)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(signet)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(knuckleDuster)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(glove)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(bracer)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(brassKnuckles)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(watch)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(bangles)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(bracelets)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(amulet)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(necklace)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(scarab)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(collar)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(brooch)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(ribbon)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(bowTie)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(pendant)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(chain)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(choker)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(tie)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(carcanet)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(torc)));

    String expectedResult = "********************Character Alice Details********************\n"
        + "\n" + "Name: Alice\n" + "\n" + "Head Gear : Helmet of Strength\n"
        + "Footwear : Boots of Momentum and Speed\n"
        + "Hand Gear : Handcuffs of Passion, Invisibility, Ambush, Charge, Holding, "
        + "Storm, Shock, Explosion, Telepathy and Flame\n"
        + "Jewelry : Amulet of Electricity, Sight, Burning, Teleportation, Ice, Magic, "
        + "Escape, Ruin, Telepathy, Flight, Healing, Sleep and Flame\n" + "\n"
        + "Attack Strength: 66\n" + "Defence Strength: 133\n\n";
    String actualResult = alice.getCharacterDetails();

    assertEquals(expectedResult, actualResult);

    // Test dressUp Characters with More Than Allowed Gears, some gears should be
    // discarded and then print the character details.
    assertEquals(false, Objects.isNull(alice.dressUpGear(headband)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(fingerlessGloves)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(wristBand)));

    expectedResult = "********************Character Alice Details********************\n" + "\n"
        + "Name: Alice\n" + "\n" + "Head Gear : Headband of Shock\n"
        + "Footwear : Boots of Momentum and Speed\n"
        + "Hand Gear : WristBand of Persuasion, Holding, Telepathy, Storm, Rain, Explosion, "
        + "Invisibility, Charge, Ambush and Flame\n"
        + "Jewelry : Brooch of Ice, Escape, Ruin, Telepathy, Flight, Magic, Sleep, Electricity, "
        + "Flame, Burning, Healing, Sight and Teleportation\n" + "\n" + "Attack Strength: 68\n"
        + "Defence Strength: 161\n" + "\n" + "Discared Item List:\n"
        + "- Helmet of Strength replaced by Headband of Shock\n"
        + "- Brass Knuckles of Shock replaced by Fingerless Gloves of Rain\n"
        + "- Handcuffs of Passion replaced by WristBand of Persuasion\n" + "";
    actualResult = alice.getCharacterDetails();

    assertEquals(expectedResult, actualResult);

    // Adding duplicate values
    assertEquals(false, Objects.isNull(bob.dressUpGear(helmet)));
    assertEquals(false, Objects.isNull(bob.dressUpGear(boot)));
    assertEquals(false, Objects.isNull(bob.dressUpGear(boot)));
    assertEquals(false, Objects.isNull(bob.dressUpGear(ring)));
    assertEquals(false, Objects.isNull(bob.dressUpGear(signet)));
    assertEquals(false, Objects.isNull(bob.dressUpGear(ring)));
    assertEquals(false, Objects.isNull(bob.dressUpGear(signet)));

    expectedResult = "********************Character Bob Details********************\n" + "\n"
        + "Name: Bob\n" + "\n" + "Head Gear : Helmet of Strength\n"
        + "Footwear : Boots of Momentum and Momentum\n"
        + "Hand Gear : Ring of Invisibility, Ambush, Invisibility and Ambush\n" + "\n"
        + "Attack Strength: 22\n" + "Defence Strength: 30\n" + "\n" + "";
    actualResult = bob.getCharacterDetails();

    assertEquals(expectedResult, actualResult);

    // Adding gear which is not compatible and cannot be replaced by any gear
    assertEquals(false, Objects.isNull(bob.dressUpGear(cap)));
    expectedResult = "********************Character Bob Details********************\n" + "\n"
        + "Name: Bob\n" + "\n" + "Head Gear : Helmet of Strength\n"
        + "Footwear : Boots of Momentum and Momentum\n"
        + "Hand Gear : Ring of Invisibility, Invisibility, Ambush and Ambush\n" + "\n"
        + "Attack Strength: 22\n" + "Defence Strength: 30\n" + "\n" + "Discared Item List:\n"
        + "- Cap of Electricity\n";
    actualResult = bob.getCharacterDetails();

    assertEquals(expectedResult, actualResult);
  }

  /**
   * Test Characters hitpoints in different rounds as gears wornonout.
   */

  @Test
  public void testCharacterHitPointsInDifferentRounds() {
    // When there are no gears
    int round = 1;
    Pair<Integer, Integer> expectedResult = new Pair<Integer, Integer>(10, 20);
    Pair<Integer, Integer> actualResult = alice.characterHitPoints(round);

    assertEquals(expectedResult, actualResult);

    assertEquals(false, Objects.isNull(alice.dressUpGear(helmet)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(boot)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(sandal)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(handcuffs)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(ring)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(signet)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(knuckleDuster)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(glove)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(bracer)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(brassKnuckles)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(watch)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(bangles)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(bracelets)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(amulet)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(necklace)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(scarab)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(collar)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(brooch)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(ribbon)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(bowTie)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(pendant)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(chain)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(choker)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(tie)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(carcanet)));
    assertEquals(false, Objects.isNull(alice.dressUpGear(torc)));

    // After adding gears in round 1
    expectedResult = new Pair<Integer, Integer>(66, 133);
    actualResult = alice.characterHitPoints(round);

    assertEquals(expectedResult, actualResult);

    // After adding gears in round 2
    round = 2;
    expectedResult = new Pair<Integer, Integer>(49, 84);
    actualResult = alice.characterHitPoints(round);

    assertEquals(expectedResult, actualResult);

    // After adding gears in round 3
    round = 3;
    expectedResult = new Pair<Integer, Integer>(32, 35);
    actualResult = alice.characterHitPoints(round);

    assertEquals(expectedResult, actualResult);

    // After adding gears in round 4
    round = 4;
    expectedResult = new Pair<Integer, Integer>(15, -14);
    actualResult = alice.characterHitPoints(round);

    assertEquals(expectedResult, actualResult);

    // After adding gears in round 5, because of gear worn out, characters hit
    // points are decreasing
    round = 5;
    expectedResult = new Pair<Integer, Integer>(-2, -63);
    actualResult = alice.characterHitPoints(round);

    assertEquals(expectedResult, actualResult);
  }

  /**
   * Test different gears combined description.
   */

  @Test
  public void testDifferentGearCombinedDescription() {

    CharacterWearingHandler handler = new CharacterWearingHandler();
    List<IGear> gearsList = new ArrayList<IGear>();
    gearsList.add(amulet);
    gearsList.add(bangles);
    gearsList.add(boot);
    gearsList.add(sandal);
    gearsList.add(helmet);
    gearsList.add(handcuffs);
    gearsList.add(glove);
    gearsList.add(cowl);
    gearsList.add(chain);

    for (IGear item : gearsList) {
      item.accept(handler);
    }

    String expectedResultHeadGear = "Head Gear : Helmet of Strength";
    String actualResultHeadGear = handler.getHeadGearDescription();

    assertEquals(expectedResultHeadGear, actualResultHeadGear);

    String expectedResultFootwear = "Footwear : Boots of Momentum, Speed";
    String actualResultFootwear = handler.getFootWearDescription();

    assertEquals(expectedResultFootwear, actualResultFootwear);

    String expectedResultHandGear = "Hand Gear : Bangles of Telepathy, Passion, Holding";
    String actualResultHandGear = handler.getHandGearDescription();

    assertEquals(expectedResultHandGear, actualResultHandGear);

    String expectedResultJewelry = "Jewelry : Amulet of Electricity, Explosion, Telepathy";
    String actualResultJewelry = handler.getJewelryDescription();

    assertEquals(expectedResultJewelry, actualResultJewelry);

  }

  /**
   * Test Gear value.
   */
  @Test
  public void testGearValue() {
    int round = 1;
    GearStrengthHandler handler = new GearStrengthHandler(round);

    helmet.accept(handler);

    int expectedResult = 10;
    int actualResult = handler.getTotaldefenseValue();

    assertEquals(expectedResult, actualResult);

    // Gear will worn out in next round
    round = 2;
    handler = new GearStrengthHandler(round);

    helmet.accept(handler);

    expectedResult = 8;
    actualResult = handler.getTotaldefenseValue();

    assertEquals(expectedResult, actualResult);

    // Gear will worn out in next round
    round = 3;
    handler = new GearStrengthHandler(round);

    helmet.accept(handler);

    expectedResult = 6;
    actualResult = handler.getTotaldefenseValue();

    assertEquals(expectedResult, actualResult);
  }

  /**
   * Test GearAllowedHandler passing Gear as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testGearAllowedHandlerwithNullValues() {
    IGear gear = null;

    GearAllowedHandler handler = new GearAllowedHandler(1, 2, 10);

    gear.accept(handler);
  }

  /**
   * Test GearAllowedHandler passing HandGear as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testGearAllowedHandlerwithHandGearNullValues() {
    HandGear gear = null;

    GearAllowedHandler handler = new GearAllowedHandler(1, 2, 10);

    gear.accept(handler);
  }

  /**
   * Test GearAllowedHandler passing Footwear as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testGearAllowedHandlerwithFootwearNullValues() {
    Footwear gear = null;

    GearAllowedHandler handler = new GearAllowedHandler(1, 2, 10);

    gear.accept(handler);
  }

  /**
   * Test GearAllowedHandler passing HeadGear as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testGearAllowedHandlerwithHeadGearNullValues() {
    HeadGear gear = null;

    GearAllowedHandler handler = new GearAllowedHandler(1, 2, 10);

    gear.accept(handler);
  }

  /**
   * Test GearAllowedHandler passing Jewelry as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testGearAllowedHandlerwithJewelryNullValues() {
    Jewelry gear = null;

    GearAllowedHandler handler = new GearAllowedHandler(1, 2, 10);

    gear.accept(handler);
  }

  /**
   * Test weather Head gears Allowed more than the limit i.e 1.
   */

  @Test
  public void testHeadGearsAllowed() {
    GearAllowedHandler handler = new GearAllowedHandler(0, 0, 0);

    cap.accept(handler);

    assertEquals(true, handler.getIsAllowed());

    CountGearHandler countHandler = new CountGearHandler();
    int currentHeadGearValue = 0;

    List<IGear> headGearsList = new ArrayList<IGear>();
    headGearsList.add(helmet);

    for (IGear item : headGearsList) {
      item.accept(countHandler);
    }

    currentHeadGearValue = countHandler.getHeadGearCount();

    assertEquals(1, currentHeadGearValue);

    handler = new GearAllowedHandler(currentHeadGearValue, 0, 0);

    cap.accept(handler);

    assertEquals(false, handler.getIsAllowed());
  }

  /**
   * Test weather Footwear Allowed more than the limit i.e 2.
   */

  @Test
  public void testFootwearAllowed() {
    GearAllowedHandler handler = new GearAllowedHandler(0, 0, 0);

    sandal.accept(handler);

    assertEquals(true, handler.getIsAllowed());

    CountGearHandler countHandler = new CountGearHandler();
    int currentFootwearValue = 0;

    List<IGear> footwearList = new ArrayList<IGear>();
    footwearList.add(sandal);
    footwearList.add(boot);

    for (IGear item : footwearList) {
      item.accept(countHandler);
    }

    currentFootwearValue = countHandler.getFootwearCount();

    assertEquals(2, currentFootwearValue);

    handler = new GearAllowedHandler(0, 0, currentFootwearValue);

    hoverboard.accept(handler);

    assertEquals(false, handler.getIsAllowed());
  }

  /**
   * Test weather HandGear Allowed more than the limit i.e 10.
   */
  @Test
  public void testHandGearsAllowed() {
    GearAllowedHandler handler = new GearAllowedHandler(0, 0, 0);

    ring.accept(handler);

    assertEquals(true, handler.getIsAllowed());

    CountGearHandler countHandler = new CountGearHandler();
    int currentHandGearValue = 0;

    List<IGear> handGearsList = new ArrayList<IGear>();
    handGearsList.add(ring);
    handGearsList.add(signet);
    handGearsList.add(knuckleDuster);
    handGearsList.add(glove);
    handGearsList.add(bracer);
    handGearsList.add(brassKnuckles);
    handGearsList.add(watch);
    handGearsList.add(bangles);
    handGearsList.add(bracelets);
    handGearsList.add(handcuffs);

    for (IGear item : handGearsList) {
      item.accept(countHandler);
    }

    currentHandGearValue = countHandler.getHandGearCount();

    assertEquals(10, currentHandGearValue);

    handler = new GearAllowedHandler(0, currentHandGearValue, 0);

    wristBand.accept(handler);

    assertEquals(false, handler.getIsAllowed());
  }

  /**
   * Test weather Jewelry Allowed, there is no limit.
   */
  @Test
  public void testJewelryAllowed() {
    GearAllowedHandler handler = new GearAllowedHandler(0, 0, 0);

    amulet.accept(handler);

    assertEquals(true, handler.getIsAllowed());

    CountGearHandler countHandler = new CountGearHandler();
    int currentHandGearValue = 0;

    List<IGear> jewelryList = new ArrayList<IGear>();
    jewelryList.add(amulet);
    jewelryList.add(necklace);
    jewelryList.add(choker);
    jewelryList.add(scarab);

    for (IGear item : jewelryList) {
      item.accept(countHandler);
    }

    currentHandGearValue = countHandler.getJewelryCount();

    assertEquals(4, currentHandGearValue);

    handler = new GearAllowedHandler(0, 0, 0);

    collar.accept(handler);

    assertEquals(true, handler.getIsAllowed());
  }

}

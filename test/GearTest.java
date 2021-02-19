import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import game.Attack;
import game.Defense;
import game.Footwear;
import game.HandGear;
import game.HeadGear;
import game.IGear;
import game.Jewelry;

/**
 * A JUnit test class for the IGear.
 */
public class GearTest {
  private static IGear helmet;
  private static IGear headband;
  private static IGear sandal;
  private static IGear hoverboard;
  private static IGear fitBand;
  private static IGear handcuffs;
  private static IGear mittens;
  private static IGear torc;
  private static IGear cowl;

  @Before
  public void setUp() {
    helmet = new HeadGear("Helmet of Strength", "Strength", 20, new Defense(10));
    headband = new HeadGear("Headband of Shock", "Shock", 40, new Defense(15));

    sandal = new Footwear("Sandals of Speed", "Speed", 20, new Attack(10));
    hoverboard = new Footwear("Hoverboard of Heft", "Heft", 40, new Attack(8));

    mittens = new HandGear("Mittens of Disguise", "Disguise", 10, new Attack(18));
    fitBand = new HandGear("FitBand of Speed", "Speed", 10, new Attack(20));
    handcuffs = new HandGear("Handcuffs of Passion", "Passion", 10, new Defense(2));

    torc = new Jewelry("Torc of Flame", "Flame", 0, new Attack(-5));
    cowl = new Jewelry("Cowl of Explosion", "Explosion", 40, new Defense(25));
  }

  /**
   * Test HeadGear created correctly.
   */

  @Test
  public void testHeadGearCreatedCorrectly() {
    assertEquals("Helmet of Strength", helmet.toString());
  }

  /**
   * Test HandGear created correctly.
   */

  @Test
  public void testHandGearCreatedCorrectly() {
    assertEquals("Mittens of Disguise", mittens.toString());
  }

  /**
   * Test Footwear created correctly.
   */

  @Test
  public void testFootwearCreatedCorrectly() {
    assertEquals("Sandals of Speed", sandal.toString());
  }

  /**
   * Test Jewelry created correctly.
   */

  @Test
  public void testJewelryCreatedCorrectly() {
    assertEquals("Torc of Flame", torc.toString());
  }

  /**
   * Test two HeadGears.
   */

  @Test
  public void testCompareTwoHeadGear() {
    assertEquals(-1, helmet.compareTo(headband));
    assertEquals(1, headband.compareTo(helmet));
    assertEquals(0, headband.compareTo(headband));
  }

  /**
   * Test HeadGears with other types of Gear.
   */

  @Test
  public void testCompareHeadGearWithDifferentGears() {
    assertEquals(1, helmet.compareTo(sandal));
    assertEquals(1, helmet.compareTo(handcuffs));
    assertEquals(1, helmet.compareTo(torc));
  }

  /**
   * Test two Footwears.
   */

  @Test
  public void testCompareTwoFootwears() {
    assertEquals(1, sandal.compareTo(hoverboard));
    assertEquals(-1, hoverboard.compareTo(sandal));
    assertEquals(0, hoverboard.compareTo(hoverboard));
  }

  /**
   * Test Footwears with other types of Gear.
   */

  @Test
  public void testCompareFootwearWithDifferentGears() {
    assertEquals(1, sandal.compareTo(helmet));
    assertEquals(1, sandal.compareTo(handcuffs));
    assertEquals(1, sandal.compareTo(torc));
  }

  /**
   * Test two HandGears.
   */

  @Test
  public void testCompareTwoHandGears() {
    assertEquals(-1, handcuffs.compareTo(fitBand));
    assertEquals(0, fitBand.compareTo(handcuffs));
    assertEquals(1, fitBand.compareTo(mittens));
    assertEquals(0, fitBand.compareTo(fitBand));
  }

  /**
   * Test HandGears with other types of Gear.
   */

  @Test
  public void testCompareHandGearWithDifferentGears() {
    assertEquals(1, handcuffs.compareTo(helmet));
    assertEquals(1, handcuffs.compareTo(sandal));
    assertEquals(1, handcuffs.compareTo(torc));
  }

  /**
   * Test two Jewelry.
   */

  @Test
  public void testCompareTwoJewelry() {
    assertEquals(0, torc.compareTo(cowl));
    assertEquals(-1, cowl.compareTo(torc));
    assertEquals(0, torc.compareTo(torc));
  }

  /**
   * Test Jewelry with other types of Gear.
   */

  @Test
  public void testCompareJewelryWithDifferentGears() {
    assertEquals(1, torc.compareTo(helmet));
    assertEquals(1, torc.compareTo(sandal));
    assertEquals(1, torc.compareTo(handcuffs));
  }

  /**
   * Test HeadGear Compare with Null.
   */
  @Test(expected = NullPointerException.class)
  public void testHeadgearGearsCompareWithNull() {
    helmet.compareTo(null);
  }

  /**
   * Test HandGear Compare with Null.
   */
  @Test(expected = NullPointerException.class)
  public void testHandgearGearsCompareWithNull() {
    mittens.compareTo(null);
  }

  /**
   * Test FootWear Compare with Null.
   */
  @Test(expected = NullPointerException.class)
  public void testFootwearGearsCompareWithNull() {
    sandal.compareTo(null);
  }

  /**
   * Test Jewelry Compare with Null.
   */
  @Test(expected = NullPointerException.class)
  public void testJewelryGearsCompareWithNull() {
    torc.compareTo(null);
  }

  /**
   * Test HeadGear passing Gear Full Name as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testFeadGearWithFullNameAsNull() {
    helmet = new HeadGear(null, "Strength", 20, new Defense(10));
  }

  /**
   * Test HeadGear passing Gear Adjective Name as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testHeadGearWithAdjectiveNameAsNull() {
    helmet = new HeadGear("Helmet of Strength", null, 20, new Defense(10));
  }

  /**
   * Test HeadGear passing defense value as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testHeadGearWithDefenceAsNull() {
    helmet = new HeadGear("Helmet of Strength", "Strength", 10, null);
  }

  /**
   * Test HandGear passing Gear Full Name as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testHandGearWithFullNameAsNull() {
    mittens = new HandGear(null, "Disguise", 10, new Attack(18));
  }

  /**
   * Test HandGear passing Gear Adjective Name as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testHandGearWithAdjectiveNameAsNull() {
    mittens = new HandGear("Mittens of Disguise", null, 10, new Attack(18));
  }

  /**
   * Test HandGear passing Strength as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testHandGearWithDefenceAsNull() {
    mittens = new HandGear("Mittens of Disguise", "Disguise", 10, null);
  }

  /**
   * Test FootWear passing Gear Full Name as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testFootWearWithFullNameAsNull() {
    sandal = new Footwear(null, "Speed", 20, new Attack(10));
  }

  /**
   * Test FootWear passing Gear Adjective Name as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testFootWearWithAdjectiveNameAsNull() {
    sandal = new Footwear("Sandals of Speed", null, 20, new Attack(10));
  }

  /**
   * Test FootWear passing Strength as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testFootWearWithDefenceAsNull() {
    sandal = new Footwear("Sandals of Speed", "Speed", 20, null);
  }

  /**
   * Test Jewelry passing Gear Full Name as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testJewelryWithFullNameAsNull() {
    torc = new Jewelry(null, "Flame", 0, new Attack(-5));
  }

  /**
   * Test Jewelry passing Gear Adjective Name as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testJewelryWithAdjectiveNameAsNull() {
    torc = new Jewelry("Torc of Flame", null, 0, new Attack(-5));
  }

  /**
   * Test Jewelry passing Strength as Null.
   */
  @Test(expected = NullPointerException.class)
  public void testJewelryWithDefenceAsNull() {
    torc = new Jewelry("Torc of Flame", "Flame", 0, null);
  }

}

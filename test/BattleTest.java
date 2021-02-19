import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import game.Attack;
import game.Battle;
import game.Character;
import game.Defense;
import game.Footwear;
import game.HandGear;
import game.HeadGear;
import game.IBattle;
import game.ICharacter;
import game.IGear;
import game.Jewelry;

/**
 * A JUnit test class for the IBattle.
 */
public class BattleTest {
  private static IGear helmet;
  private static IGear cap;
  private static IGear sandal;
  private static IGear hoverboard;
  private static IGear boot;
  private static IGear slippers;
  private static IGear ring;
  private static IGear signet;
  private static IGear knuckleDuster;
  private static IGear glove;
  private static IGear bracer;
  private static IGear brassKnuckles;
  private static IGear watch;
  private static IGear bangles;
  private static IGear handcuffs;
  private static IGear mittens;
  private static IGear ribbon;
  private static IGear bowTie;
  private static IGear pendant;
  private static IGear chain;
  private static IGear choker;
  private static ICharacter alice;
  private static ICharacter bob;
  private static IBattle battle;

  @Before
  public void setUp() {
    helmet = new HeadGear("Helmet of Strength", "Strength", 20, new Defense(10));
    cap = new HeadGear("Cap of Electricity", "Electricity", 0, new Defense(-1));

    sandal = new Footwear("Sandals of Speed", "Speed", 20, new Attack(10));
    hoverboard = new Footwear("Hoverboard of Heft", "Heft", 40, new Attack(8));
    boot = new Footwear("Boots of Momentum", "Momentum", 20, new Attack(6));
    slippers = new Footwear("Slippers of Swimming", "Swimming", 0, new Attack(-10));

    ring = new HandGear("Ring of Invisibility", "Invisibility", 0, new Attack(-5));
    signet = new HandGear("Signet of Ambush", "Ambush", 25, new Attack(5));
    knuckleDuster = new HandGear("Knuckle Duster of Charge", "Charge", 40, new Attack(3));
    glove = new HandGear("Gloves of Holding", "Holding", 40, new Defense(5));
    bracer = new HandGear("Bracer of Storm", "Storm", 50, new Defense(15));
    brassKnuckles = new HandGear("Brass Knuckles of Shock", "Shock", 0, new Defense(-5));
    watch = new HandGear("Watch of Explosion", "Explosion", 80, new Defense(25));
    bangles = new HandGear("Bangles of Telepathy", "Telepathy", 20, new Defense(10));
    handcuffs = new HandGear("Handcuffs of Passion", "Passion", 10, new Defense(2));
    mittens = new HandGear("Mittens of Disguise", "Disguise", 10, new Attack(18));

    ribbon = new Jewelry("Ribbon of Magic", "Magic", 60, new Defense(15));
    bowTie = new Jewelry("BowTie of Escape", "Escape", 50, new Defense(5));
    pendant = new Jewelry("Pendant of Ruin", "Ruin", 10, new Defense(5));
    chain = new Jewelry("Chain of Telepathy", "Telepathy", 20, new Defense(5));
    choker = new Jewelry("Choker of Flight", "Flight", 10, new Defense(11));
    alice = new Character("Alice", 10, 20, 100);
    bob = new Character("Bob", 10, 20, 100);
  }

  /**
   * Test Battle Constructor.
   */
  @Test
  public void testBattleConstructor() {
    IBattle battle = new Battle(alice, bob);
    assertEquals("Alice and Bob are in battle.", battle.toString());
  }

  /**
   * Test Player1 passed as null.
   */
  @Test(expected = NullPointerException.class)
  public void testPlayer1PassedAsNull() {
    battle = new Battle(null, bob);
  }

  /**
   * Test Player2 passed as null.
   */
  @Test(expected = NullPointerException.class)
  public void testPlayer2PassedAsNull() {
    battle = new Battle(alice, null);
  }

  /**
   * Test Predict winner between two players.
   */
  @Test
  public void testPredictWinner() {
    alice.dressUpGear(helmet);
    alice.dressUpGear(boot);
    alice.dressUpGear(sandal);
    alice.dressUpGear(handcuffs);
    alice.dressUpGear(ring);
    alice.dressUpGear(signet);
    alice.dressUpGear(knuckleDuster);
    alice.dressUpGear(glove);
    alice.dressUpGear(bracer);
    alice.dressUpGear(brassKnuckles);
    alice.dressUpGear(watch);
    alice.dressUpGear(bangles);

    bob.dressUpGear(bowTie);
    bob.dressUpGear(chain);
    bob.dressUpGear(pendant);
    bob.dressUpGear(hoverboard);
    bob.dressUpGear(ribbon);
    bob.dressUpGear(choker);
    bob.dressUpGear(cap);
    bob.dressUpGear(mittens);
    bob.dressUpGear(slippers);

    battle = new Battle(alice, bob);
    int playersHeath = 100;

    String expectedResult = "*************** Battle Prediction ***************\n\n"
        + "Bob a winner, survived 8 rounds.";
    String actualResult = battle.predictWinner(playersHeath);

    assertEquals(expectedResult, actualResult);

    battle = new Battle(bob, alice);

    expectedResult = "*************** Battle Prediction ***************\n\n"
        + "Bob a winner, survived 8 rounds.";
    actualResult = battle.predictWinner(playersHeath);

    assertEquals(expectedResult, actualResult);
  }

  /**
   * Test Predict tie between two players.
   */
  @Test
  public void testPredictWinnerAndThereIsATie() {
    alice.dressUpGear(helmet);
    alice.dressUpGear(boot);
    alice.dressUpGear(sandal);
    alice.dressUpGear(handcuffs);
    alice.dressUpGear(ring);
    alice.dressUpGear(signet);
    alice.dressUpGear(knuckleDuster);
    alice.dressUpGear(glove);
    alice.dressUpGear(bracer);
    alice.dressUpGear(brassKnuckles);
    alice.dressUpGear(watch);
    alice.dressUpGear(bangles);

    ICharacter alex = new Character("Alex", 10, 20, 100);
    alex.dressUpGear(helmet);
    alex.dressUpGear(boot);
    alex.dressUpGear(sandal);
    alex.dressUpGear(handcuffs);
    alex.dressUpGear(ring);
    alex.dressUpGear(signet);
    alex.dressUpGear(knuckleDuster);
    alex.dressUpGear(glove);
    alex.dressUpGear(bracer);
    alex.dressUpGear(brassKnuckles);
    alex.dressUpGear(watch);
    alex.dressUpGear(bangles);

    battle = new Battle(alice, alex);
    int playersHeath = 100;

    String expectedResult = "*************** Battle Prediction ***************\n\n"
        + "Its a tie after 7 rounds.";
    String actualResult = battle.predictWinner(playersHeath);

    assertEquals(expectedResult, actualResult);

  }

}

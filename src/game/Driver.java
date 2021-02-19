package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Driver program for role playing game, that dresses two (2) characters and
 * pits them in a battle.
 */
public class Driver {

  private static IGear helmet;
  private static IGear headband;
  private static IGear mask;
  private static IGear cap;
  private static IGear sandal;
  private static IGear hoverboard;
  private static IGear boot;
  private static IGear slippers;
  private static IGear shoes;
  private static IGear rollerBlades;
  private static IGear segway;
  private static IGear sneakers;
  private static IGear ring;
  private static IGear signet;
  private static IGear knuckleDuster;
  private static IGear glove;
  private static IGear bracer;
  private static IGear brassKnuckles;
  private static IGear watch;
  private static IGear bangles;
  private static IGear bracelets;
  private static IGear fingerRings;
  private static IGear fitBand;
  private static IGear handcuffs;
  private static IGear mittens;
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
  private static IGear gaiter;

  private static ICharacter Bob;
  private static ICharacter Alice;

  /**
   * Driver program that dresses two characters and pits them in a battle and
   * prints output for the various functionalities.
   * 
   * @param args Not used.
   */
  public static void main(String[] args) {

    Boolean isRematch = true;

    createGears();
    prepareCharactersforBattle();
    predictWinner();

    Scanner scanner = new Scanner(System.in);
    while (isRematch) {

      final String yesOption = "yes";
      final String noOption = "no";
      String promptMessage = "\n\nDo you want a rematch? Reply Yes/No\n";
      System.out.print(promptMessage);
      String userReply = scanner.nextLine();

      if (yesOption.equalsIgnoreCase(userReply)) {
        prepareCharactersforBattle();
        predictWinner();
      } else if (noOption.equalsIgnoreCase(userReply)) {
        System.out.println("No rematch\n");
        isRematch = false;
      } else {
        System.out.println("Wrong input given. No rematch\n");
        isRematch = false;
      }
    }
    scanner.close();
  }

  /**
   * Private Helper method to create and dress each character with a random 20
   * items from the chest of gear and print the output for each character in the
   * battle along with what they are wearing and their attack and defense
   * strength.
   * 
   */
  private static void prepareCharactersforBattle() {
    createCharacters();
    System.out.println("********************Characters are wearing items********************\n");
    populateChest(Alice);
    System.out.println("\n");
    populateChest(Bob);
    System.out.println("\n");
    System.out.println(Alice.getCharacterDetails());
    System.out.println(Bob.getCharacterDetails());
  }

  /**
   * Private Helper method to Predict which of the two characters would win in a
   * battle and print its output.
   */
  private static void predictWinner() {
    String matchPredictionResult = Alice.predictWinner(Bob);

    System.out.println(matchPredictionResult);
  }

  /**
   * Private Helper method create two characters for the battle.
   */
  private static void createCharacters() {
    Bob = new Character("Bob", 5, 20, 100);
    Alice = new Character("Alice", 15, 10, 100);
  }

  /**
   * Private Helper method create multiple gears for the battle.
   */
  private static void createGears() {
    helmet = new HeadGear("Helmet of Strength", "Strength", 20, new Defense(10));
    headband = new HeadGear("Headband of Shock", "Shock", 40, new Defense(15));
    mask = new HeadGear("Mask of Flight", "Flight", 40, new Defense(5));
    cap = new HeadGear("Cap of Electricity", "Electricity", 0, new Defense(-1));

    sandal = new Footwear("Sandals of Speed", "Speed", 20, new Attack(10));
    hoverboard = new Footwear("Hoverboard of Heft", "Heft", 40, new Attack(8));
    boot = new Footwear("Boots of Momentum", "Momentum", 20, new Attack(6));
    slippers = new Footwear("Slippers of Swimming", "Swimming", 0, new Attack(-10));
    shoes = new Footwear("Shoes of Drunkeness", "Drunkeness", 20, new Attack(25));
    rollerBlades = new Footwear("RollerBlades of Sight", "Sight", 30, new Attack(8));
    segway = new Footwear("Segway of Healing", "Healing", 30, new Attack(2));
    sneakers = new Footwear("Sneakers of Sleep", "Sleep", 40, new Attack(6));

    ring = new HandGear("Ring of Invisibility", "Invisibility", 0, new Attack(-5));
    signet = new HandGear("Signet of Ambush", "Ambush", 25, new Attack(5));
    knuckleDuster = new HandGear("Knuckle Duster of Charge", "Charge", 40, new Attack(3));
    glove = new HandGear("Gloves of Holding", "Holding", 40, new Defense(5));
    bracer = new HandGear("Bracer of Storm", "Storm", 50, new Defense(15));
    brassKnuckles = new HandGear("Brass Knuckles of Shock", "Shock", 0, new Defense(-5));
    watch = new HandGear("Watch of Explosion", "Explosion", 80, new Defense(25));
    bangles = new HandGear("Bangles of Telepathy", "Telepathy", 20, new Defense(10));
    bracelets = new HandGear("Bracelets of Flame", "Flame", 20, new Attack(8));
    fingerRings = new HandGear("FingerRings of Sight", "Sight", 0, new Attack(-2));
    fitBand = new HandGear("FitBand of Speed", "Speed", 10, new Attack(20));
    handcuffs = new HandGear("Handcuffs of Passion", "Passion", 10, new Defense(2));
    mittens = new HandGear("Mittens of Disguise", "Disguise", 10, new Attack(18));
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
    gaiter = new Jewelry("Gaiter of Disguise", "Disguise", 0, new Attack(-25));
  }

  /**
   * Private Helper method to populate the chest of gear with a minimum of 4 items
   * of headgear, 8 items of footwear, 15 items of hand gear, and 15 items of
   * jewelry and Dress each character with a random 20 items from the chest of
   * gear.
   * 
   */
  private static void populateChest(ICharacter character) {
    List<IGear> gearsList = new ArrayList<>();
    gearsList.add(helmet);
    gearsList.add(headband);
    gearsList.add(mask);
    gearsList.add(cap);

    gearsList.add(sandal);
    gearsList.add(hoverboard);
    gearsList.add(boot);
    gearsList.add(slippers);
    gearsList.add(shoes);
    gearsList.add(rollerBlades);
    gearsList.add(segway);
    gearsList.add(sneakers);

    gearsList.add(ring);
    gearsList.add(signet);
    gearsList.add(knuckleDuster);
    gearsList.add(glove);
    gearsList.add(bracer);
    gearsList.add(brassKnuckles);
    gearsList.add(watch);
    gearsList.add(bangles);
    gearsList.add(bracelets);
    gearsList.add(fingerRings);
    gearsList.add(fitBand);
    gearsList.add(handcuffs);
    gearsList.add(mittens);
    gearsList.add(fingerlessGloves);
    gearsList.add(wristBand);

    gearsList.add(amulet);
    gearsList.add(necklace);
    gearsList.add(scarab);
    gearsList.add(collar);
    gearsList.add(brooch);
    gearsList.add(ribbon);
    gearsList.add(bowTie);
    gearsList.add(pendant);
    gearsList.add(chain);
    gearsList.add(choker);
    gearsList.add(tie);
    gearsList.add(carcanet);
    gearsList.add(torc);
    gearsList.add(cowl);
    gearsList.add(gaiter);

    int listSize = gearsList.size();

    for (int i = 0; i < 20; i++) {
      int index = getRandomNumber(0, listSize - 1);
      System.out.println(character.dressUpGear(gearsList.get(index)));
    }
  }

  /**
   * Private Helper method to generate the random number within the given range.
   * 
   * @param min It is the minimum range
   * @param max It is the maximum range
   * 
   */
  private static int getRandomNumber(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min) + min;
  }

}

package rolePlayingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

  public static void main(String[] args) {
    createCharacters();
    createGears();
    
    populateChest(Alice);

    System.out.println(Alice.printCharacterDetails());
  }

  private static void createCharacters() {
    Bob = new Character("Bob", 10, 5, 20);
    Alice = new Character("Alice", 5, 15, 10);
  }

  private static void createGears() {
    helmet = new HeadGear("Helmet of Strength", "Strength", 2, new Defence(10));
    headband = new HeadGear("Headband of Shock", "Shock", 4, new Defence(15));
    mask = new HeadGear("Mask of Flight", "Flight", 4, new Defence(5));
    cap = new HeadGear("Cap of Electricity", "Electricity", 0, new Defence(-1));

    sandal = new Footwear("Sandals of Speed", "Speed", 2, new Attack(10));
    hoverboard = new Footwear("Hoverboard of Heft", "Heft", 4, new Attack(8));
    boot = new Footwear("Boots of Momentum", "Momentum", 2, new Attack(6));
    slippers = new Footwear("Slippers of Swimming", "Swimming", 0, new Attack(-10));
    shoes = new Footwear("Shoes of Drunkeness", "Drunkeness", 2, new Attack(25));
    rollerBlades = new Footwear("RollerBlades of Sight", "Sight", 2, new Attack(8));
    segway = new Footwear("Segway of Healing", "Healing", 2, new Attack(2));
    sneakers = new Footwear("Sneakers of Sleep", "Sleep", 2, new Attack(6));

    ring = new HandGear("Ring of Invisibility", "Invisibility", 0, new Attack(-5));
    signet = new HandGear("Signet of Ambush", "Ambush", 2, new Attack(5));
    knuckleDuster = new HandGear("Knuckle Duster of Charge", "Charge", 4, new Attack(3));
    glove = new HandGear("Gloves of Holding", "Holding", 4, new Defence(5));
    bracer = new HandGear("Bracer of Storm", "Storm", 5, new Defence(15));
    brassKnuckles = new HandGear("Brass Knuckles of Shock", "Shock", 0, new Defence(-5));
    watch = new HandGear("Watch of Explosion", "Explosion", 8, new Defence(25));
    bangles = new HandGear("Bangles of Telepathy", "Telepathy", 2, new Defence(10));
    bracelets = new HandGear("Bracelets of Flame", "Flame", 2, new Attack(8));
    fingerRings = new HandGear("FingerRings of Sight", "Sight", 0, new Attack(-2));
    fitBand = new HandGear("FitBand of Speed", "Speed", 10, new Attack(20));
    handcuffs = new HandGear("Handcuffs of Passion", "Passion", 9, new Defence(2));
    mittens = new HandGear("Mittens of Disguise", "Disguise", 10, new Attack(18));
    fingerlessGloves = new HandGear("Fingerless Gloves of Rain", "Rain", 0, new Defence(20));
    wristBand = new HandGear("WristBand of Persuasion", "Persuasion", 4, new Attack(2));

    amulet = new Jewelry("Amulet of Electricity", "Electricity", 0, new Attack(-5));
    necklace = new Jewelry("Necklace of Sight", "Sight", 2, new Attack(10));
    scarab = new Jewelry("Scarab of Burning", "Burning", 3, new Attack(5));
    collar = new Jewelry("Collar of Teleportation", "Teleportation", 4, new Attack(15));
    brooch = new Jewelry("Brooch of Ice", "Ice", 0, new Defence(-5));
    ribbon = new Jewelry("Ribbon of Magic", "Magic", 6, new Defence(15));
    bowTie = new Jewelry("BowTie of Escape", "Escape", 5, new Defence(5));
    pendant = new Jewelry("Pendant of Ruin", "Ruin", 7, new Defence(5));
    chain = new Jewelry("Chain of Telepathy", "Telepathy", 8, new Defence(5));    
    choker = new Jewelry("Choker of Flight", "Flight", 10, new Defence(11));
    tie = new Jewelry("Tie of Healing", "Healing", 9, new Attack(9));
    carcanet = new Jewelry("Carcanet of Sleep", "Sleep", 2, new Defence(15));
    torc = new Jewelry("Torc of Flame", "Flame", 0, new Attack(-5));
    cowl = new Jewelry("Cowl of Explosion", "Explosion", 6, new Defence(25));
    gaiter = new Jewelry("Gaiter of Disguise", "Disguise", 0, new Attack(-25));
  }

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
    
    for(int i=0; i< 20; i++)
    {
      int index = getRandomNumber(0,listSize-1);
      character.dressUpGear(gearsList.get(index));
    }
  }
  
  public static int getRandomNumber(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min) + min;
}

}

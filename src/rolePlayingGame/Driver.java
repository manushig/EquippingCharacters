package rolePlayingGame;

public class Driver {

  private static IGear helmet;
  private static IGear headband;
  private static IGear sandal;
  private static IGear hoverboard;
  private static IGear boot;
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
  private static IGear amulet;
  private static IGear necklace;
  private static IGear scarab;
  private static IGear collar;
  private static IGear brooch;
  private static IGear ribbon;
  private static IGear bowTie;
  private static ICharacter Bob;
  private static ICharacter Alice;

  public static void main(String[] args) {
    createCharacters();
    createGears();
    
    Alice.addGear(helmet);
    Alice.addGear(headband);
    
    Alice.addGear(hoverboard);
    Alice.addGear(boot);
    Alice.addGear(sandal);
    
    Alice.addGear(ring);
    Alice.addGear(signet);
    Alice.addGear(knuckleDuster);
    Alice.addGear(glove);
    Alice.addGear(bracer);
    Alice.addGear(brassKnuckles);
    Alice.addGear(watch);
    Alice.addGear(bangles);
    Alice.addGear(bracelets);
    Alice.addGear(fingerRings);
    Alice.addGear(fitBand);
    
    Alice.addGear(amulet);
    Alice.addGear(scarab);
    Alice.addGear(collar);
    Alice.addGear(brooch);
    Alice.addGear(ribbon);
    Alice.addGear(bowTie);
  }
  

  private static void createCharacters() {
    Bob = new Character(10, 5, 20);
    Alice = new Character(5, 15, 10);
  }

  private static void createGears() {
    helmet = new HeadGear("Helmet of Strength", "Strength", 2, 10);
    headband = new HeadGear("Headband of Shock", "Shock", 4, 15);

    sandal = new Footwear("Sandals of Speed", "Speed", 2, 10);
    hoverboard = new Footwear("Hoverboard of Heft", "Heft", 4, 8);
    boot = new Footwear("Boots of Momentum", "Momentum", 2, 6);

    ring = new HandGear("Ring of Invisibility", "Invisibility", 0, new Attack(-5));
    signet = new HandGear("Signet of Ambush", "Ambush", 0, new Attack(5));
    knuckleDuster = new HandGear("Knuckle Duster of Charge", "Charge", 0, new Attack(5));
    glove = new HandGear("Gloves of Holding", "Holding", 0, new Defence(5));
    bracer = new HandGear("Bracer of Storm", "Storm", 0, new Defence(15));
    brassKnuckles = new HandGear("Brass Knuckles of Shock", "Shock", 0, new Defence(-5));
    watch = new HandGear("Watch of Explosion", "Explosion", 0, new Defence(-5));
    bangles = new HandGear("Bangles of Telepathy", "Telepathy", 0, new Defence(-5));
    bracelets = new HandGear("Bracelets of Flame", "Flame", 0, new Defence(-5));
    fingerRings = new HandGear("FingerRings of Sight", "Sight", 0, new Defence(-5));
    fitBand = new HandGear("FitBand of Speed", "Speed", 0, new Defence(-5));

    amulet = new Jewelry("Amulet of Electricity", "Electricity", 0, new Attack(-5));
    necklace = new Jewelry("Necklace of Sight", "Sight", 0, new Attack(10));
    scarab = new Jewelry("Scarab of Burning", "Burning", 0, new Attack(5));
    collar = new Jewelry("Collar of Teleportation", "Teleportation", 0, new Attack(15));
    brooch = new Jewelry("Brooch of Ice", "Ice", 0, new Defence(-5));
    ribbon = new Jewelry("Ribbon of Magic", "Magic", 0, new Defence(15));
    bowTie = new Jewelry("BowTie of Escape", "Escape", 0, new Defence(5));
  }

}

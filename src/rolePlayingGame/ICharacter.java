package rolePlayingGame;

import javafx.util.Pair;

public interface ICharacter {
  public ICharacter dressUpGear(IGear gear);
  
  public String printCharacterDetails();
  
  public Pair<Integer, Integer> characterHitPoints(int round);
}

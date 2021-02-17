package rolePlayingGame;

public interface IGear extends Comparable<IGear> {

  public int getCount();
  
  public void accept(GearVisitor visitor);
}

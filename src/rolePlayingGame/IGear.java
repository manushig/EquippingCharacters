package rolePlayingGame;

public interface IGear extends Comparable<IGear> {
  public Boolean getResult();

  public int getCount();
  
  public void accept(GearVisitor visitor);
}

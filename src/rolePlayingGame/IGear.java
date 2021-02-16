package rolePlayingGame;

public interface IGear extends Comparable<IGear> {
  public IGear isAllowed(IGear gear);

  public Boolean getResult();

  public int getCount();
  
  public void accept(GearVisitor visitor);
}

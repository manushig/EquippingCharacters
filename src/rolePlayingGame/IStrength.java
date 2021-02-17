package rolePlayingGame;

public interface IStrength extends Comparable<IStrength> {
  
  public void accept(StrengthVisitor visitor);
}

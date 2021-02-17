package rolePlayingGame;

public class Defence extends AbstractStrength {

  public Defence(int defenceStrength)
  {
    super(defenceStrength);
  }
  
  @Override
  public int compareTo(IStrength other) {
    if (other instanceof AbstractStrength) {
      AbstractStrength strength = (AbstractStrength) other;
      return strength.compareToDefence(this);
    }
    else
    {
      return -1;
    }
  }

  @Override
  protected int compareToDefence(Defence other) {
    return other.getStrength().compareTo(this.getStrength());
  }
  
  @Override
  public void accept(StrengthVisitor visitor) {
    visitor.visit(this);

  }
}

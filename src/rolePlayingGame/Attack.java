package rolePlayingGame;

public class Attack extends AbstractStrength {

  public Attack(int attackStrength) {
    super(attackStrength);
  }

  @Override
  public int compareTo(IStrength other) {
    if (other instanceof AbstractStrength) {
      AbstractStrength strength = (AbstractStrength) other;
      return strength.compareToAttack(this);
    }
    else
    {
      return 1;
    }
  }

  @Override
  protected int compareToAttack(Attack other) {
    return other.getStrength().compareTo(this.getStrength());
  }
}

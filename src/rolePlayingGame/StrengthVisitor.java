package rolePlayingGame;

public interface StrengthVisitor {
  public void visit(Attack attack);
  
  public void visit(Defence defence);
}

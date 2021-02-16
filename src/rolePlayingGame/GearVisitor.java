package rolePlayingGame;

public interface GearVisitor {
  public void visit(HeadGear headGear);

  public void visit(Footwear footwear);

  public void visit(HandGear handGear);

  public void visit(Jewelry jewelry);
}

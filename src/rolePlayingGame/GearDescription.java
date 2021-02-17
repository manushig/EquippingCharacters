package rolePlayingGame;

public class GearDescription {

  private String itemsFullName;
  private String itemsAdjective;

  public GearDescription(String fullName, String adjective) {
    this.itemsFullName = fullName;
    this.itemsAdjective = adjective;
  }

  @Override
  public String toString() {
    return String.format(this.itemsFullName + "and " + this.itemsAdjective);
  }

  public String getItemsFullName() {
    return this.itemsFullName;
  }

  public String getItemsAdjective() {
    return this.itemsAdjective;
  }
  
  
}

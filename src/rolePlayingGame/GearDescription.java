package rolePlayingGame;

import java.util.Objects;

public class GearDescription {

  private String itemsFullName;
  private String itemsAdjective;

  public GearDescription(String fullName, String adjective) {
    this.itemsFullName = Objects.requireNonNull(fullName, "Full Name value cannot be null");
    this.itemsAdjective = Objects.requireNonNull(adjective, "Adjective value cannot be null");
  }
  
  public GearDescription(GearDescription gearDescriptionToCopy) {
    this.itemsFullName = gearDescriptionToCopy.itemsFullName;
    this.itemsAdjective = gearDescriptionToCopy.itemsAdjective;
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

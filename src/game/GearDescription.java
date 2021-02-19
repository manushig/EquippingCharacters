package game;

import java.util.Objects;

/**
 * GearDescription, it holds the gear's description.
 */
public class GearDescription {

  private final String itemsFullName;
  private final String itemsAdjective;

  /**
   * Constructs a GearDescription in terms of gear's fullName and adjective.
   *
   * @param fullName  It is the gear's fullName.
   * @param adjective It is the gear's adjective name.
   * @throws NullPointerException If gear's full name or adjective value is null.
   */
  public GearDescription(String fullName, String adjective) {
    this.itemsFullName = Objects.requireNonNull(fullName, "Full Name value cannot be null");
    this.itemsAdjective = Objects.requireNonNull(adjective, "Adjective value cannot be null");
  }

  /**
   * Constructs a GearDescription to copy gear's fullName and adjective.
   *
   * @param gearDescriptionToCopy It is GearDescription whose copy needs to make.
   * @throws NullPointerException If gearDescription to copy value is null
   */
  public GearDescription(GearDescription gearDescriptionToCopy) throws IllegalArgumentException {
    if (Objects.isNull(gearDescriptionToCopy)) {
      throw new IllegalArgumentException("gearDescription to copy value cannot be null");
    }
    this.itemsFullName = gearDescriptionToCopy.itemsFullName;
    this.itemsAdjective = gearDescriptionToCopy.itemsAdjective;
  }

  /**
   * Gets the Gear's Full Name.
   *
   * @return gear's full Name.
   */
  public String getItemsFullName() {
    return this.itemsFullName;
  }

  /**
   * Gets the Gear's Adjective Name.
   *
   * @return gear's Adjective Name.
   */
  public String getItemsAdjective() {
    return this.itemsAdjective;
  }

}

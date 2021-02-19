package game;

import java.util.Objects;

/**
 * GearDiscarded, it maintains the gear which is discarded by a character and
 * the gear which replaced the discarded gear.
 */
public class GearDiscarded {
  private final IGear discardedGear;
  private final IGear replacedByGear;

  /**
   * Constructs a GearDiscarded in terms of discarded Gear and replaced Gear.
   *
   * @param discardedGear  It is the gear which is discarded by a character
   * @param replacedByGear It is the gear which replaced the discarded gear. This
   *                       value can be null when gear is discarded without even
   *                       replaced by any other gear.
   * @throws NullPointerException If discarded gear value is null.
   */
  public GearDiscarded(IGear discardedGear, IGear replacedByGear) {
    this.discardedGear = Objects.requireNonNull(discardedGear,
        "Discarded Gear value cannot be null");
    this.replacedByGear = replacedByGear;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(discardedGear.toString());
    if (!Objects.isNull(this.replacedByGear)) {
      stringBuilder.append(" replaced by " + replacedByGear.toString());
    }

    return stringBuilder.toString();
  }

}

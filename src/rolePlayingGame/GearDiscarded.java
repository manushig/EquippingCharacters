package rolePlayingGame;

import java.util.Objects;

public class GearDiscarded {
  private IGear discardedGear;
  private IGear replacedByGear;

  public GearDiscarded(IGear discardedGear, IGear replacedByGear) {
    this.discardedGear = Objects.requireNonNull(discardedGear,
        "Discarded Gear value cannot be null");
    this.replacedByGear = replacedByGear; // This value can be null. Scenario when gear is discarded
                                          // without even replaced by any other gear.
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

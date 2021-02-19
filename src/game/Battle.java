package game;

import java.util.Objects;

import javafx.util.Pair;

/**
 * Battle, it is where battle between two players will happen.
 */
public class Battle implements IBattle {

  private enum MatchStatus {
    PLAYER_1_WINNER, PLAYER_2_WINNER, TIE;
  }

  private final ICharacter player1;
  private final ICharacter player2;

  /**
   * Constructs a Battle in terms of its player1 and player2.
   *
   * @param player1 It is the Player 1.
   * @param player2 It is the Player 2.
   */
  public Battle(ICharacter player1, ICharacter player2) {
    this.player1 = Objects.requireNonNull(player1, "Player1 value cannot be null");
    this.player2 = Objects.requireNonNull(player2, "Player1 value cannot be null");
  }

  @Override
  public String predictWinner(int playersTotalHealth) throws IllegalArgumentException {

    if (Objects.isNull(playersTotalHealth)) {
      throw new IllegalArgumentException("Players total health value cannot be null");
    }
    if (playersTotalHealth == 0) {
      throw new IllegalArgumentException("Players total health value cannot be 0");
    }

    String result = "";
    StringBuilder stringBuilder = new StringBuilder();
    MatchStatus matchResult = null;
    Pair<Integer, Integer> player1HitPoints;
    Pair<Integer, Integer> player2HitPoints;
    int player1Attack = 0;
    int player1Defence = 0;
    int player2Attack = 0;
    int player2Defence = 0;
    int player1Damage = 0;
    int player2Damage = 0;
    int player1Health = playersTotalHealth;
    int player2Health = playersTotalHealth;

    int round = 1;
    Boolean isMatchContinuing = true;

    while (isMatchContinuing) {
      player1HitPoints = Objects.requireNonNull(player1.characterHitPoints(round),
          "Player Hit points value cannot be null");
      player1Attack = player1HitPoints.getKey();
      player1Defence = player1HitPoints.getValue();

      if (player1Attack < 0) {
        player1Attack = 0;
      }
      if (player1Defence < 0) {
        player1Defence = 0;
      }

      player2HitPoints = Objects.requireNonNull(player2.characterHitPoints(round),
          "Player Hit points value cannot be null");
      player2Attack = player2HitPoints.getKey();
      player2Defence = player2HitPoints.getValue();

      if (player2Attack < 0) {
        player2Attack = 0;
      }
      if (player2Defence < 0) {
        player2Defence = 0;
      }

      player1Damage = player2Attack - player1Defence;
      player2Damage = player1Attack - player2Defence;

      if (player1Damage < 0) {
        player1Damage = 0;
      }

      if (player2Damage < 0) {
        player2Damage = 0;
      }

      player1Health = player1Health - player1Damage;
      player2Health = player2Health - player2Damage;

      if (player1Health <= 0 && player2Health <= 0) {
        matchResult = MatchStatus.TIE;
        isMatchContinuing = false;
      } else if (player1Health <= 0) {
        matchResult = MatchStatus.PLAYER_2_WINNER;
        isMatchContinuing = false;
      } else if (player2Health <= 0) {
        matchResult = MatchStatus.PLAYER_1_WINNER;
        isMatchContinuing = false;
      } else if (player1Attack == 0 && player2Attack == 0 && player1Defence == 0
          && player2Defence == 0) {
        if (player1Health > player2Health) {
          matchResult = MatchStatus.PLAYER_1_WINNER;
        } else if (player1Health < player2Health) {
          matchResult = MatchStatus.PLAYER_2_WINNER;
        } else {
          matchResult = MatchStatus.TIE;
        }
        isMatchContinuing = false;

      } else {
        round++;
      }
    }

    result = predictionResult(matchResult, round);

    stringBuilder.append("*************** Battle Prediction ***************\n\n");
    stringBuilder.append(result);
    return stringBuilder.toString();
  }

  /**
   * Private helper method to give the prediction result based on matchResult.
   *
   * @param matchResult This is match result
   * @param round       This is the round till which players survived
   * @return prediction result based on matchResult.
   */
  private String predictionResult(MatchStatus matchResult, int round) {
    String result = "";

    switch (matchResult) {
      case TIE:
        result = String.format("Its a tie after %d rounds.", round);
        break;
      case PLAYER_1_WINNER:
        result = String.format("%s a winner, survived %d rounds.", player1.toString(), round);
        break;
      case PLAYER_2_WINNER:
        result = String.format("%s a winner, survived %d rounds.", player2.toString(), round);
        break;
      default:
        result = String.format("Something went wrong. Try again");
    }

    return result;
  }

  @Override
  public String toString() {
    return String.format("%s and %s are in battle.", player1.toString(), player2.toString());
  }
}

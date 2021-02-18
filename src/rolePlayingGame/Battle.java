package rolePlayingGame;

import java.util.Objects;

import javafx.util.Pair;

/**
 * Battle, it is where battle between two players will happen.
 */
public class Battle implements IBattle {

  private enum MatchStatus {
    PLAYER_1_WINNER, PLAYER_2_WINNER, TIE;
  }

  private ICharacter player1;
  private ICharacter player2;

  /**
   * Constructs a Battle in terms of its player1 and player2
   *
   * @param player1 It is the Player 1.
   * @param player2 It is the Player 2.
   * @throws NullPointerException If player1 or player2 values are null.
   */
  public Battle(ICharacter player1, ICharacter player2) throws NullPointerException {
    if (Objects.isNull(player1)) {
      throw new NullPointerException("Player1 value cannot be null");
    }
    if (Objects.isNull(player2)) {
      throw new NullPointerException("Player2 value cannot be null");
    }
    this.player1 = player1;
    this.player2 = player2;
  }

  @Override
  public String predictWinner(int playersTotalHealth)
      throws NullPointerException, IllegalArgumentException {

    if (Objects.isNull(playersTotalHealth)) {
      throw new NullPointerException("Players total health value cannot be null");
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
    Boolean IsMatchContinuing = true;

    while (IsMatchContinuing) {
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
        IsMatchContinuing = false;
      } else if (player1Health <= 0) {
        matchResult = MatchStatus.PLAYER_2_WINNER;
        IsMatchContinuing = false;
      } else if (player2Health <= 0) {
        matchResult = MatchStatus.PLAYER_1_WINNER;
        IsMatchContinuing = false;
      }

      else if (round == 98 && IsMatchContinuing) {
        IsMatchContinuing = false;
      } else if ((player1Attack == 0 && player2Attack == 0 && player1Defence == 0
          && player2Defence == 0) || (round == 50 && IsMatchContinuing)) {
        if (player1Health > player2Health) {
          matchResult = MatchStatus.PLAYER_1_WINNER;
        } else if (player1Health < player2Health) {
          matchResult = MatchStatus.PLAYER_2_WINNER;
        } else {
          matchResult = MatchStatus.TIE;
        }
        IsMatchContinuing = false;

      } else {
        round++;
      }
    }

    switch (matchResult) {
    case TIE:
      result = String.format("Its a tie after %d rounds.", round);
      break;
    case PLAYER_1_WINNER:
      result = String.format("%s a winner, survived %d rounds", player1.toString(), round);
      break;
    case PLAYER_2_WINNER:
      result = String.format("%s a winner, survived %d rounds", player1.toString(), round);
      break;
    default:
      result = String.format("Something went wrong. Try again");
    }

    stringBuilder.append("*************** Battle Prediction ***************\n\n");
    stringBuilder.append(result);
    return stringBuilder.toString();
  }

}

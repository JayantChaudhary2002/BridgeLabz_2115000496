package IPL_Censor_Analyzer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IPLMatch {
    private int match_id;
    private String team1;
    private String team2;
    private Score score;
    private String winner;
    private String player_of_match;

    // Getters and Setters

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getPlayer_of_match() {
        return player_of_match;
    }

    public void setPlayer_of_match(String player_of_match) {
        this.player_of_match = player_of_match;
    }
}

class Score {
    @JsonProperty("Mumbai Indians")
    private int team1Score;
    @JsonProperty("Chennai Super Kings")
    private int team2Score;

    // Getters and Setters
    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }
}

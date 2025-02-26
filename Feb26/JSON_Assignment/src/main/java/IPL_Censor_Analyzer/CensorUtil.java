package IPL_Censor_Analyzer;
public class CensorUtil {

    // Censor team names by replacing part of the team name with "***"
    public static String censorTeamName(String teamName) {
        if (teamName.contains("Mumbai")) {
            return "Mumbai ***";
        } else if (teamName.contains("Chennai")) {
            return "Chennai ***";
        } else if (teamName.contains("Royal")) {
            return "Royal ***";
        } else if (teamName.contains("Delhi")) {
            return "Delhi ***";
        }
        return teamName;
    }

    // Redact the player of the match by replacing the name with "REDACTED"
    public static String redactPlayerOfMatch(String playerName) {
        return "REDACTED";
    }

    // Apply censorship to an IPLMatch object
    public static IPLMatch applyCensorship(IPLMatch match) {
        match.setTeam1(censorTeamName(match.getTeam1()));
        match.setTeam2(censorTeamName(match.getTeam2()));
        match.setPlayer_of_match(redactPlayerOfMatch(match.getPlayer_of_match()));
        return match;
    }
}

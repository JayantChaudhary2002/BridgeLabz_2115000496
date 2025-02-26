package IPL_Censor_Analyzer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IPLCsvProcessor {

    // Read CSV file into a list of IPLMatch objects
    public static List<IPLMatch> readCsv(String filePath) throws IOException {
        List<IPLMatch> matches = new ArrayList<>();
        Reader reader = new FileReader(filePath);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(reader);

        for (CSVRecord record : records) {
            IPLMatch match = new IPLMatch();
            match.setMatch_id(Integer.parseInt(record.get("match_id")));
            match.setTeam1(record.get("team1"));
            match.setTeam2(record.get("team2"));
            Score score = new Score();
            score.setTeam1Score(Integer.parseInt(record.get("score_team1")));
            score.setTeam2Score(Integer.parseInt(record.get("score_team2")));
            match.setScore(score);
            match.setWinner(record.get("winner"));
            match.setPlayer_of_match(record.get("player_of_match"));
            matches.add(match);
        }
        return matches;
    }

    // Write a list of IPLMatch objects to a CSV file
    public static void writeCsv(List<IPLMatch> matches, String filePath) throws IOException {
        Writer writer = new FileWriter(filePath);
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("match_id", "team1", "team2", "score_team1", "score_team2", "winner", "player_of_match"));

        for (IPLMatch match : matches) {
            csvPrinter.printRecord(
                    match.getMatch_id(),
                    match.getTeam1(),
                    match.getTeam2(),
                    match.getScore().getTeam1Score(),
                    match.getScore().getTeam2Score(),
                    match.getWinner(),
                    match.getPlayer_of_match()
            );
        }
        csvPrinter.flush();
        csvPrinter.close();
    }
}

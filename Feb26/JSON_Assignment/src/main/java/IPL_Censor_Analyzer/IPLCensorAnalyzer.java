package IPL_Censor_Analyzer;
import java.io.IOException;
import java.util.List;

public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        try {
            // Read and process JSON data
            List<IPLMatch> jsonMatches = IPLJsonProcessor.readJson("ipl_data.json");
            for (int i = 0; i < jsonMatches.size(); i++) {
                jsonMatches.set(i, CensorUtil.applyCensorship(jsonMatches.get(i)));
            }
            IPLJsonProcessor.writeJson(jsonMatches, "ipl_data_censored.json");

            // Read and process CSV data
            List<IPLMatch> csvMatches = IPLCsvProcessor.readCsv("ipl_data.csv");
            for (int i = 0; i < csvMatches.size(); i++) {
                csvMatches.set(i, CensorUtil.applyCensorship(csvMatches.get(i)));
            }
            IPLCsvProcessor.writeCsv(csvMatches, "ipl_data_censored.csv");

            System.out.println("Censorship applied and files saved successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

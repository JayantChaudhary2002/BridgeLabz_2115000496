package IPL_Censor_Analyzer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class IPLJsonProcessor {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Read JSON file into a list of IPLMatch objects
    public static List<IPLMatch> readJson(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, IPLMatch.class));
    }

    // Write a list of IPLMatch objects to a JSON file
    public static void writeJson(List<IPLMatch> matches, String filePath) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), matches);
    }
}

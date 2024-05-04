import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigReader {
    private final String fileName;

    public ConfigReader(String fileName) {
        this.fileName = fileName;
    }

    public Map<String, Integer> getConfig() throws IOException {
        Map<String, Integer> wordToNumberMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String word = parts[0].trim();
                    int number = Integer.parseInt(parts[1].trim());
                    wordToNumberMap.put(word, number);
                }
            }
        }
        return wordToNumberMap;
    }
}
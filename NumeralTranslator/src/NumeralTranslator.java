import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class NumeralTranslator {
    public static void main(String[] args) {
        try {
            ConfigReader configReader = new ConfigReader();
            WordToNumberMap wordToNumberMap = new WordToNumberMap(configReader.readConfig("./src/config.json"));
            String text = readFile("./src/input.txt"); // Имя файла с текстом
            String convertedText = wordToNumberMap.ConvertNumbers(text);
            System.out.println(convertedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }
}
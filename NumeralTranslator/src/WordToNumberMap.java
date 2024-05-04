import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordToNumberMap {
    private final Map<String, Integer> wordToNumberMap;

    public WordToNumberMap(Map<String, Integer> wordToNumberMap) {
        this.wordToNumberMap = wordToNumberMap;
    }

    public String ConvertNumbers(String text) {
        Pattern pattern = Pattern.compile("\\b([а-я]+)\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            Integer number = wordToNumberMap.get(word);
            if (number != null) {
                matcher.appendReplacement(result, String.valueOf(number));
            } else {
                matcher.appendReplacement(result, word);
            }
        }
        matcher.appendTail(result);
        return result.toString();
    }
}

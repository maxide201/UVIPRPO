import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordToNumberMap {
    private final Map<String, Integer> wordToNumberMap;
    private final String regex;

    public WordToNumberMap(Map<String, Integer> wordToNumberMap) {
        this.wordToNumberMap = wordToNumberMap;
        var keys = wordToNumberMap.keySet().toArray(new String[0]);
        Arrays.sort(keys, Comparator.comparingInt(String::length).reversed());
        var keySetStr = String.join("|", keys);
        regex = "(?:"+keySetStr+")(?:\\s+(?:"+keySetStr+"))*";
    }

    public String ConvertNumbers(String text) {
        StringBuilder result = new StringBuilder(text);

        // Создаем паттерн и матчер
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Заменяем числа, записанные словами, на числа
        while (matcher.find()) {
            String match = matcher.group();
            var numbers =  match.trim().split(" ");
            var res = 0;
            var hub = 0;
            for(var i = 0; i < numbers.length; i++) {
                var curNum = wordToNumberMap.get(numbers[i]);
                hub += curNum;
                if(i+1 < numbers.length) {
                    var nextNum = wordToNumberMap.get(numbers[i+1]);
                    if (curNum < nextNum) {
                        res += hub * nextNum;
                        hub = 0;
                        i++;
                    }
                }
                else {
                    res+=hub;
                }
            }
            matcher.appendReplacement(result, res + "");
        }
        matcher.appendTail(result);

        return result.toString();

    }
}

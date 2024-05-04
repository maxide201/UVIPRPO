import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "две тысячи один ежик и два гвоздя";
        String replacedText = replaceWordsWithDigits(text);
        System.out.println(replacedText);
    }

    public static String replaceWordsWithDigits(String text) {
        Map<String, Integer> wordToNumber = new HashMap<>();
        wordToNumber.put("один", 1);
        wordToNumber.put("два", 2);
        wordToNumber.put("две", 2);
        // другие числительные до 1000
        wordToNumber.put("тысяча", 1000);
        wordToNumber.put("тысячи", 1000);
        // другие числительные после 1000

        // Создаем паттерн для поиска числительных и их контекста
        String regex = "(?:один|два|две|тысяча|тысячи)(?:\\s+(?:один|два|две|тысяча|тысячи))*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            String match = matcher.group();
            var numbers =  match.trim().split(" ");
            var res = 0;
            for(var i = 0; i < numbers.length; i++) {
                var curNum = wordToNumber.get(numbers[i]);
                if(i+1 < numbers.length) {
                    var nextNum = wordToNumber.get(numbers[i+1]);
                    if (curNum < nextNum) {
                        res += curNum * nextNum;
                        i++;
                        continue;
                    }
                }
                res+=curNum;
            }
            matcher.appendReplacement(result, res + "");
        }
        matcher.appendTail(result);

        return result.toString();
    }
}

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordToNumberMapTests {
    private WordToNumberMap wordToNumberMap;

    @BeforeEach
    public void setup() {
        // Создаем карту слов к числам для тестов
        Map<String, Integer> map = new HashMap<>();
        map.put("одну", 1);
        map.put("одной", 1);
        map.put("одна", 1);
        map.put("тысяча", 1000);
        map.put("тысячу", 1000);
        wordToNumberMap = new WordToNumberMap(map);
    }

    @Test
    public void testConvertNumbers() {

        assertEquals("1000 рублей", wordToNumberMap.ConvertNumbers("одна тысяча рублей"));

        assertEquals("мне 1000 кг, вместо 1 тоны", wordToNumberMap.ConvertNumbers("мне одну тысячу кг, вместо одной тоны"));
    }
}
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConfigReader {

    public Map<String, Integer> readConfig(String filePath) throws IOException, JSONException {
        // Читаем содержимое JSON файла в строку
        String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));

        // Создаем JSON объект из строки
        JSONObject jsonObject = new JSONObject(jsonContent);

        // Создаем пустую карту для хранения значений из JSON
        Map<String, Integer> configMap = new HashMap<>();

        // Итерируемся по ключам JSON объекта
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            int value = jsonObject.getInt(key); // Получаем значение по ключу как целое число
            configMap.put(key, value); // Добавляем пару ключ-значение в карту
        }

        return configMap;
    }
}
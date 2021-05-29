package lessons.httplesson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import http.User;
import lombok.SneakyThrows;

import java.util.List;

public class JsonUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T extends http.User> String writeValueAsString(T value) throws JsonProcessingException {
        return MAPPER.writeValueAsString(value);
    }

    @SneakyThrows
    public static <T extends http.User> List<User> readListValue(String body, Class<T> clazz) throws JsonProcessingException {
        JavaType listType = MAPPER.getTypeFactory().constructCollectionType(List.class, clazz);
        return MAPPER.readValue(body, listType);
    }

    @SneakyThrows
    public static <T> T readValue(String body, Class<T> valueType) throws JsonProcessingException {
        return MAPPER.readValue(body, valueType);
    }
}
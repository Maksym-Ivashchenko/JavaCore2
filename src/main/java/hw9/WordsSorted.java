package hw9;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordsSorted {
    public String toPrint(Map<Integer, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, String> count: map.entrySet())
            stringBuilder.append(count.getKey()).append(" ").append(count.getValue()).append("\n");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        WordsSorted wordsSorted = new WordsSorted();
        try (FileReader fileUsers = new FileReader("src/main/java/hw9/resources/words.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = fileUsers.read(buf)) > 0) {
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                String s = new String(buf);
                String[] strings = s.split("\\s+");

                Map<String, Integer> sortedMap = new HashMap<>();
                Map<Integer, String> sort = new TreeMap<>(Collections.reverseOrder());

                for (String str: strings){
                    if (sortedMap.containsKey(str)) {
                        sortedMap.put(str, sortedMap.get(str) + 1);
                    } else {
                        sortedMap.put(str, 1);
                    }
                }
                for (Map.Entry<String, Integer> value: sortedMap.entrySet())
                    sort.put(value.getValue(), value.getKey());
                System.out.println(wordsSorted.toPrint(sort));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
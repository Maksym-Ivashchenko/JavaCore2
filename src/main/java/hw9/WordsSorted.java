package hw9;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordsSorted {
    public String toPrint(List sortList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object count: sortList)
            stringBuilder.append(count).append("\n");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        WordsSorted wordsSorted = new WordsSorted();
        try (FileReader fileUsers = new FileReader("src/main/resources/words.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = fileUsers.read(buf)) > 0) {
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                String s = new String(buf);
                String[] strings = s.split("\\s+");

                Map<String, Integer> sortedMap = new HashMap<>();

                for (String str: strings){
                    if (sortedMap.containsKey(str)) {
                        sortedMap.put(str, sortedMap.get(str) + 1);
                    } else {
                        sortedMap.put(str, 1);
                    }
                }
                List list = new ArrayList(sortedMap.entrySet());
                Collections.sort(list, (Comparator<Map.Entry<String, Integer>>) (a, b) -> b.getValue() - a.getValue());
                System.out.println(wordsSorted.toPrint(list));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
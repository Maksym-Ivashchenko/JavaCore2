package hw9;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FilePhone {
    public static void main(String[] args) {

//task_1
        try (FileReader filePhone = new FileReader("src/main/java/hw9/resources/task1.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = filePhone.read(buf)) > 0) {
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                String s = new String(buf);
                String[] strings = s.split(System.lineSeparator());
                String regex1 = "\\d{3}-\\d{3}-\\d{4}";
                String regex2 = "\\(\\d{3}\\)\\s\\d{3}-\\d{4}";
                for (String s1: strings)
                    if (!s1.isEmpty() && s1.matches(regex1) || s1.matches(regex2))

                        System.out.println(s1 + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
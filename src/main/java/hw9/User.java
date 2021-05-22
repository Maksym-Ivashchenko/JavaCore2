package hw9;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private String name;
    private int age;
    public String fileJson;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class GsonTest {
    public static void main(String[] args) {
        try (FileReader fileUsers = new FileReader("src/main/resources/task2.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = fileUsers.read(buf)) > 0) {
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                String s = new String(buf);
                String[] strings = s.split(System.lineSeparator());

                ArrayList users = new ArrayList();
                for (String str: strings)
                    if (!str.isEmpty() && !str.equals("name age"))
                    users.add(new User(str.split(" ")[0], Integer.parseInt(str.split(" ")[1])));
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(users);

                System.out.println(json);
                try (FileWriter writeUsers = new FileWriter("src/main/resources/user.json")) {
                    writeUsers.write(json);
                    writeUsers.flush();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

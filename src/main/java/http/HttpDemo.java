package http;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public class HttpDemo {
    private static final String CREATE_USER_URL = "http://pingponggoit.herokuapp.com/createUser";
    private static final String GET_USER_BY_ID_URL = "http://pingponggoit.herokuapp.com/getUserById";
    private static final String GET_USERS_URL = "http://pingponggoit.herokuapp.com/getUsers";
    private static final String DELETE_URL = "http://pingponggoit.herokuapp.com/removeUser";

    public static void main(String[] args) throws IOException, InterruptedException {
        //Task #1
        User user = createDefaultUser();
        final User createdUser = HttpUtil.sendPost(URI.create(CREATE_USER_URL), user);

        System.out.println("Task 1 " + createdUser);

        //Task #2
        final User task2 = HttpUtil.sendGet(URI.create(String.format("%s?id=%d", GET_USER_BY_ID_URL, createdUser.getId())));
        System.out.println("Task 2 " + task2);

        //Task #3
        User task3 = createDefaultUser();
        System.out.println("Created user "+ task3);
        final User task3CreatedUser = HttpUtil.sendPost(URI.create(CREATE_USER_URL), task3);
        final List<User> users = HttpUtil.sendGetWithListOfResults(URI.create(GET_USERS_URL));
        HttpUtil.sendDelete(URI.create(DELETE_URL), task3CreatedUser);
        System.out.println("Users list before delete " + users);
        final List<User> usersAfterDelete = HttpUtil.sendGetWithListOfResults(URI.create(GET_USERS_URL));
        System.out.println("Users list after delete " + usersAfterDelete);
    }

    private static User createDefaultUser() {
        User user = new User();
        user.setId(1);
        user.setName("Vasya");
        user.setSurname("Pupkin");
        user.setGender("male");
        user.setSalary(100500);
        return user;
    }
}

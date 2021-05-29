package lessons.httplesson;

import http.User;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpDemo {
    private static final String CREATE_USER_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String OVERWRITE_URL = "https://jsonplaceholder.typicode.com/overwrite?id=%s";
    private static final String URL = "https://jsonplaceholder.typicode.com/getUserById?id=%s";
    //private static final String GET_USER_BY_ID_URL = "http://pingponggoit.herokuapp.com/getUserById";
    private static final String GET_USERS_URL = "http://pingponggoit.herokuapp.com/getUsers";
    //private static final String DELETE_URL = "http://pingponggoit.herokuapp.com/removeUser";

    public static void main(String[] args) throws IOException, InterruptedException {
        //Task #1
        final User createdUser = HttpUtil.sendPost(CREATE_USER_URL, createUser(), User.class);
        System.out.println("Task 1 " + createdUser);

        //Task #2
        User updatedUser = getUserBytId(createUser().getId());
        System.out.println("Updated user " + updatedUser);
        //final User task2 = HttpUtil.sendGet(URI.create(String.format("%s?id=%d", GET_USER_BY_ID_URL, createdUser.getId())));
        //System.out.println("Task 2 " + task2);

        //Task #3
        //User task3 = createDefaultUser();
        //System.out.println("Created user "+ task3);
        //final User task3CreatedUser = HttpUtil.sendPost(URI.create(CREATE_USER_URL), task3);
        //final List<User> users = HttpUtil.sendGetWithListOfResults(URI.create(GET_USERS_URL));
        //HttpUtil.sendDelete(URI.create(DELETE_URL), task3CreatedUser);
        //System.out.println("Users list before delete " + users);
        //final List<User> usersAfterDelete = HttpUtil.sendGetWithListOfResults(URI.create(GET_USERS_URL));
        //System.out.println("Users list after delete " + usersAfterDelete);
    }

    private static User createUser() {
        return User.builder()
                    .id(1)
                    .name("Vasya")
                    .userName("Pupkin")
                    .build();
    }

    private static void updateUser(User user) {
        try {
            HttpUtil.sendPut(String.format(OVERWRITE_URL, user.getId()), user, User.class);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error while sending put request " + e.getMessage());
        }
    }
    private static User getUserBytId(int id) {
        try {
            return HttpUtil.sendGet(String.format(URL, id), User.class);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error while sending get request " + e.getMessage());
        }
        return null;
    }

    @SneakyThrows
    private static List<User> getUsers() {
        try {
            return HttpUtil.sendGetWithListResponse(GET_USERS_URL, User.class);
        } catch (IOException e) {
            System.out.println("Error while sending get request " + e.getMessage());
        }
        return new ArrayList<>();
    }
}

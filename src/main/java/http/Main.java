package http;

import lombok.SneakyThrows;

import java.net.URI;
import java.util.List;

import static http.Utils.getUserById;

public class Main {
    private static final User DEFAULT_USER = getUserById(3);
    private static final String USER_URL = "https://jsonplaceholder.typicode.com/users";
    private static final int ID_TO_CHANGE = 2;
    private static final String USER_BY_NAME = "Chelsey Dietrich";

    @SneakyThrows
    public static void main(String[] args) {
        //POST
        User user = newUser();
        final User createdMyUser = Utils.sendPost(URI.create(USER_URL), user);
        System.out.println("Task 1.1 " + createdMyUser + "\n");

        //PUT
        User updatedUser = new User.UserBuilder()
                .id(ID_TO_CHANGE)
                .name("Mak")
                .userName("M")
                .email("ko_mi@gmail.com")
                .address(user.getAddress())
                .phoneNumber(user.getPhoneNumber())
                .website(user.getWebsite())
                .company(user.getCompany())
                .build();
        updatedUser.setName("Max");
        updatedUser.setUserName("Rex");

        User updated = Utils.sendPut(ID_TO_CHANGE, updatedUser);
        System.out.println("Task 1.2 " + updated + "\n");

        //DELETE
        int sendDelete = Utils.sendDelete(ID_TO_CHANGE);
        System.out.println("Task 1.3 " + sendDelete + "\n");

        //GET all users
        final List<User> users = Utils.sendGetWithListOfResults(URI.create(USER_URL));
        System.out.println("Task 1.4 " + users + "\n");

        //GET user_id
        final User userById = getUserById(DEFAULT_USER.getId());
        System.out.println("Task 1.5 " + userById + "\n");

        //GET/username
        final User byName = Utils.getUserByName(USER_BY_NAME);
        System.out.println("Task 1.6 " + USER_BY_NAME + "\n" + byName + "\n");

        //last post
        List<Comment> allCommentToLastPostOfUser = Utils.getAllCommentsForLastPostOfUser(userById);
        System.out.println("Task 2. User's id=" + DEFAULT_USER.getId() + " last post's comments are");
        allCommentToLastPostOfUser.forEach(System.out::println);
        System.out.println("\n");

        //uncompleted tasks
        List<Task> allUncompleted = Utils.getAllUncompletedToDos(userById);
        System.out.println("Task 3\n " + DEFAULT_USER.getId());
        allUncompleted.forEach(System.out::println);
    }


    public static User newUser() {
        return new User.UserBuilder()
                .id(1)
                .name("Maksym")
                .userName("McS")
                .email("ivashchenko_mi@gmail.com")
                .address(createNewAddress())
                .phoneNumber("+380997775533")
                .website("https://github.com/Maksym-Ivashchenko")
                .company(createNewCompany())
                .build();
    }

    private static Company createNewCompany() {
        return new Company.CompanyBuilder()
                .name("L.O.")
                .catchPhrase("Fishing & rest!")
                .bs("Java").build();
    }

    private static Address createNewAddress() {
        return new Address.AddressBuilder()
                .street("St Piece")
                .apartment("Apt. 9")
                .city("Kharkiv")
                .zipcode("3333333")
                .geo(createNewGeo())
                .build();
    }

    private static Geo createNewGeo() {
        return new Geo.GeoBuilder()
                .latitude(50.0)
                .longitude(36.15)
                .build();
    }
}

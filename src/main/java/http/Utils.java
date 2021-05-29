package http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    private static final Type USER_COLLECTION = new TypeToken<List<User>>() {
    }.getType();
    private static final Type POST_COLLECTION = new TypeToken<List<Post>>() {
    }.getType();
    private static final Type COMMENT_COLLECTION = new TypeToken<List<Comment>>() {
    }.getType();
    private static final Type TASK_COLLECTION = new TypeToken<List<Task>>() {
    }.getType();

    private static final String HOST = "https://jsonplaceholder.typicode.com";
    private static final String END_POINT = "/users";
    private static final String USER_NAME = "?username=";
    private static final String POSTS = "/posts";
    private static final String COMMENTS = "/comments";
    private static final String TODOS = "/todos";

    public static User getUserById(int id) {
        HttpRequest request = sendGet(String.format("%s%s/%d", HOST, END_POINT, id));
        HttpResponse<String> response = getResponse(request);
        return GSON.fromJson(response.body(), User.class);
    }

    public static List<User> sendGetAllUsers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(HOST + END_POINT))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), new TypeToken<List<User>>() {}.getType());
    }

    public static User getUserByName(String name) throws IOException, InterruptedException {
        List<User> allUsers = sendGetAllUsers();
        return allUsers.stream().filter(user -> user.getName().equals(name)).findAny().orElse(new User());
    }

    public static User sendPost(URI uri, User user) {
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = getResponse(request);
        return GSON.fromJson(response.body(), User.class);
    }


    public static List<User> sendGetWithListOfResults(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), USER_COLLECTION);
    }

    public static int sendDelete(int id) {
        User user1 = getUserById(id);
        final String requestBody = GSON.toJson(user1);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s/%d", HOST, END_POINT, id)))
                .header("Content-type", "application/json")
                .method("DELETE", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        return getResponse(request).statusCode();
    }


    public static User sendPut(int id, User updatedUser) throws IOException, InterruptedException {
        String requestBody = GSON.toJson(updatedUser);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s/%d", HOST, END_POINT, id)))
                .header("Content-type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);
    }


    public static List<Comment> getAllCommentsForLastPostOfUser(User user) throws IOException, InterruptedException {
        Post lastPost = getLastPost(user);
        HttpRequest request = sendGet(String.format("%s%s/%d%s", HOST, POSTS, lastPost.getId(), COMMENTS));
        String fileName = "user-" + user.getId() + "post-" + lastPost.getId() + "-comments.json";
        getResponse(request, fileName);
        return GSON.fromJson(getResponse(request).body(), COMMENT_COLLECTION);
    }

    private static Post getLastPost(User user) {
        HttpRequest request = sendGet(String.format("%s%s/%d%s", HOST, END_POINT, user.getId(), POSTS));
        List<Post> posts = GSON.fromJson(getResponse(request).body(), POST_COLLECTION);
        return Collections.max(posts, Comparator.comparingInt(Post::getId));
    }

    public static List<Task> getAllUncompletedToDos(User user) {
        HttpRequest request = sendGet(String.format("%s%s/%d%s", HOST, END_POINT, user.getId(), TODOS));
        List<Task> allToDos = GSON.fromJson(getResponse(request).body(), TASK_COLLECTION);
        return allToDos.stream()
                .filter(todo -> !todo.isCompleted())
                .collect(Collectors.toList());
    }

    private static HttpRequest sendGet(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
    }

    private static HttpResponse<String> getResponse(HttpRequest request) {
        HttpResponse<String> response = null;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }


    private static void getResponse(HttpRequest request, String fileName) throws IOException, InterruptedException {
        CLIENT.send(request, HttpResponse.BodyHandlers.ofFile(Path.of(fileName)));
    }
}
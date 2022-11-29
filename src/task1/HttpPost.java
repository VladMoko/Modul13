package task1;

import gson.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpPost {

    public static void main(String[] args) throws IOException, InterruptedException {
        User user = new User();
        user.creatorInfo();
        HttpPost post = new HttpPost();
        post.createUser();
        post.upDate();
        post.getAllUsers();
        post.getInfoAboutUserWithId();
        post.getInfoAboutUserSearchForName();
    }

    public void createUser() throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/users";

        HttpRequest post = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method("POST", HttpRequest.BodyPublishers.ofString("user.json"))
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response =
                client.send(post, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println("response.body() = " + response.body());
    }


    public void upDate() throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/users/1";

        HttpRequest put = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .PUT(HttpRequest.BodyPublishers.ofString("user.json"))
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> send = client.send(put, HttpResponse.BodyHandlers.ofString());

        System.out.println("send.statusCode() = " + send.statusCode());
        System.out.println("send.body() = " + send.body());
    }


    public void getAllUsers() {

        String url = "https://jsonplaceholder.typicode.com/users";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        try {
            HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("send.statusCode() = " + send.statusCode());
            System.out.println("send.body() = " + send.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void getInfoAboutUserWithId() throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/users/1";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("send.statusCode() = " + send.statusCode());
        System.out.println("send.body() = " + send.body());
    }


    public void getInfoAboutUserSearchForName() throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/users?username=Bret";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("send.statusCode() = " + send.statusCode());
        System.out.println("send.body() = " + send.body());
    }

}

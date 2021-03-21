package ua.hw13.http;

import ua.hw13.entities.Post;
import ua.hw13.entities.User;
import ua.hw13.utils.DataWriter;

import java.io.File;
import java.net.http.HttpResponse;

public class CustomClient extends HttpBaseClient {
    private final static String HOST = "https://jsonplaceholder.typicode.com";
    private final static String USERS = "users";
    private final static String POSTS = "posts";
    private final static String TODOS = "todos";

    public CustomClient() {
        super(HOST);
    }

    public HttpResponse<String> userCreate(User newUser) {
        return doPOST(newUser, USERS, null);
    }

    public HttpResponse<String> userUpdate(User updatingUser) {
        return doPUT(updatingUser, USERS + "/" + updatingUser.getId(), null);
    }

    public HttpResponse<String> userDelete(int userId) {
        return doDELETE(USERS + "/" + userId, null);
    }

    public HttpResponse<String> userDelete(User user) {
        return doDELETE(USERS + "/" + user.getId(), null);
    }

    public HttpResponse<String> usersGet() {
        return doGET(USERS, null);
    }

    public HttpResponse<String> userGetById(int userId) {
        return doGET(USERS + "/" + userId, null);
    }

    public HttpResponse<String> userGetByUsername(String username) {
        return doGET(USERS, "username=" + username);
    }

    public HttpResponse<String> postsGetByUserId(int userId) {
        return doGET(POSTS, "userId=" + userId);
    }

    public HttpResponse<String> commentsGetByPostId(int postId) {
        return doGET(POSTS + "/" + postId + "/comments", null);
    }

    public File commentsGetByLastPostToFile(int userId) {
        postsGetByUserId(userId);
        Post[] posts = responseToObject(Post[].class);
        int lastPostId = posts[posts.length - 1].getId();
        commentsGetByPostId(lastPostId);
        String path = "json/user-" + userId + "-post-" + lastPostId + "-comments.json";
        return DataWriter.printToFile(responseToString(), path);
    }

    public HttpResponse<String> todosOpenGetByUserId(int userId) {
        return doGET(USERS + "/" + userId + "/" + TODOS, "completed=false");
    }
}
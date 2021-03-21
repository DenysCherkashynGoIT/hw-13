package ua.hw13.entities;

//some class ToDo for example
public class ToDo {
    int userId;
    int id;
    String title;
    boolean completed;

    public ToDo(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = false;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

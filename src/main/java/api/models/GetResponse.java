package api.models;

public class GetResponse {
    private int userId;
    private int id;
    private String title;
    private String body;

    // Getters
    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}

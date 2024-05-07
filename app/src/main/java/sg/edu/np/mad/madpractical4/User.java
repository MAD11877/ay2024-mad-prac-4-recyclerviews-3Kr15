package sg.edu.np.mad.madpractical4;

public class User {
    private String name;
    private String description;
    private int id;
    private boolean followed;
    private int smallImageResourceId;

    public void setName(String username) { this.name = username; }
    public void setDescription(String description) { this.description = description; }
    public void setId(int id) { this.id = id; }
    public void setFollowed(boolean followed) { this.followed = followed; }
    public void setSmallImageResourceId(int smallImage) { this.smallImageResourceId = smallImage; }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean getFollowed() { return followed; }
    public int getSmallImageResourceId() { return smallImageResourceId; }
    public User(String name, String description, int id, boolean followed, int smallImage) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
        this.smallImageResourceId = smallImage;
    }
}

package ultrasupreem.aret;

public class User {
    String firstName;
    String lastName;
    String email;
    String password;
    String region;
    boolean token;

    public User() {
        token = false;
    }

    public User(String firstName, String lastName, String email, String password, String region) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.region = region;
        token = true;
    }
}

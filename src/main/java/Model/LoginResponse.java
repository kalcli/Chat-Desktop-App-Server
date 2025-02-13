package Model;

import java.io.Serializable;
import java.util.List;

public class LoginResponse implements Serializable {
    private User authenticatedUser;
    private List<User> userList;

    public LoginResponse(User authenticatedUser, List<User> userList) {
        this.authenticatedUser = authenticatedUser;
        this.userList = userList;
    }

    public User getAuthenticatedUser() {
        return authenticatedUser;
    }

    public List<User> getUserList() {
        return userList;
    }
}

package mock.user;

public interface UserService {

    void saveUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserByUsername(String username);
}

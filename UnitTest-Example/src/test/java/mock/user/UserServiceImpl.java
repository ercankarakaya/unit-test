package mock.user;

public class UserServiceImpl implements UserService{


    @Override
    public void saveUser(User user) {
        System.out.println("saveUser("+user.getUsername()+")");
    }

    @Override
    public void updateUser(User user) {
        System.out.println("updateUser("+user.getUsername()+")");
    }

    @Override
    public void removeUser(int id) {
        System.out.println("removeUser("+id+")");
    }

    @Override
    public String getUsername(String username) {
        return "getUsername("+username+")";
    }
}

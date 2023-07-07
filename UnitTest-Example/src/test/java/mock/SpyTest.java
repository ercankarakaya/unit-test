package mock;

import mock.user.User;
import mock.user.UserService;
import mock.user.UserServiceImpl;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;


public class SpyTest {

    @Test
    public void testSpy() throws Exception{

        UserService userService = spy(new UserServiceImpl());

        User user1 = new User(1,"user1");
        User user2 = new User(2,"user2");

        doNothing().when(userService).saveUser(eq(user1)); // only valid for user1.
        doThrow(new IllegalArgumentException()).when(userService).removeUser(anyInt());

//        userService.saveUser(user1);

//        userService.saveUser(user2);
//        userService.removeUser(anyInt());

        doNothing().when(userService).removeUser(1);
        doNothing().when(userService).removeUser(2);
        doCallRealMethod().when(userService).removeUser(3);

        userService.removeUser(1);
        userService.removeUser(2);
        userService.removeUser(3);  // output: removeUser(3)


    }
}

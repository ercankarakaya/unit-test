package mock;

import mock.user.User;
import mock.user.UserService;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class BehaviourTest {

    @Test
    public void testBehaviour() throws Exception {

        UserService userService = mock(UserService.class);

        User user1 = new User(1,"user1");
        User user2 = new User(2,"user2");

        userService.saveUser(user1);
        userService.saveUser(user2);

        verify(userService).saveUser(user1);
        verify(userService).saveUser(user2);

        // Let's test how many times it is called


    }

    @Test
    public void testHowManyTimesCalled() throws Exception{
        UserService userService = mock(UserService.class);

        User user1 = new User(1,"user1");
        User user2 = new User(2,"user2");

        userService.saveUser(user1);
        userService.saveUser(user1);
        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user2);

        // 3 times saveUser(user1) called.
        verify(userService,times(3)).saveUser(user1);
        // 2 times saveUser(user2) called.
        verify(userService,times(2)).saveUser(user2);

        // removeUser was never called.
        verify(userService,never()).removeUser(anyInt());

        // saveUser was never called for 'user3' object.
        verify(userService,never()).saveUser(new User(3,"user3"));

        // Called at least 2 times.
        verify(userService,atLeast(2)).saveUser(user2);

    }

    @Test
    public void testCheckSequence() throws Exception{  // test sırasını kontrol et

        UserService userService = mock(UserService.class);

        User user1 = new User(1,"user1");
        User user2 = new User(2,"user2");
        User user3 = new User(3,"user3");

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.updateUser(user3);

        InOrder inOrder = inOrder(userService); // inOrder(userService,...)

        inOrder.verify(userService).saveUser(user1);     // order 1
        inOrder.verify(userService).saveUser(user2);    // order 2
        inOrder.verify(userService).updateUser(user3); // order 3

    }

    @Test
    public void testNoOtherCheck() throws Exception {  // başka kontrol yok

        UserService userService = mock(UserService.class);

        User user1 = new User(1,"user1");
        User user2 = new User(2,"user2");
        int userId = 3;

        userService.saveUser(user1);
        userService.removeUser(userId);
       // userService.saveUser(user2);

        verify(userService).saveUser(user1);
        verify(userService).removeUser(userId);

        verifyNoMoreInteractions(userService);  // No more calls
    }

    @Test
    public void testNoOtherCheck2() throws Exception {

        UserService userService1 = mock(UserService.class);
        UserService userService2 = mock(UserService.class);

        User user1 = new User(1,"user1");
        User user2 = new User(2,"user2");
        int userId = 3;

        userService1.saveUser(user1);
        userService1.removeUser(userId);
        //userService1.saveUser(user2);

        verify(userService1).saveUser(user1);
        verify(userService1).removeUser(userId);

        verifyZeroInteractions(userService1);  // Never be called


    }
}

package mock;

import mock.user.UserService;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

public class PreliminaryTest {

    @Test
    public void testWhen() throws Exception{

        UserService userService = mock(UserService.class);
        // when(userService.getUsername(anyString())).thenReturn("usernameUser1");
        // when(userService.getUsername(eq("user2"))).thenReturn("usernameUser1");
        when(userService.getUsername(eq("user1"))).thenReturn("usernameUser1");

        String username = userService.getUsername("user1");

        assertThat(username).isEqualTo("usernameUser1");
    }

    @Test
    public void testWhen2() throws Exception{

        UserService userService = mock(UserService.class);
        when(userService.getUsername(eq("user1"))).thenThrow(new RuntimeException());

        String username = userService.getUsername("user1");
    }


    @Test
    public void testWhen3() throws Exception {

        // void methodlar (geri dönüşü olmayan) için nasıl when kullanımı

        UserService userService = mock(UserService.class);

        doNothing().when(userService).saveUser(anyObject());

        doThrow(new RuntimeException()).when(userService).saveUser(anyObject());

        doReturn("user2").when(userService).getUsername("user1");
    }

}

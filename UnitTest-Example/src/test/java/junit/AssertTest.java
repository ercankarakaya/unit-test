package junit;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class AssertTest {


    @Test
    public void testAssertions(){

        /*
        String[] arr1 = {"1","2","3","4"};
        String[] arr2 = {"1","2","3"};
        assertSame(arr1,arr2);
         */

        /*
        User user1 = new User(10);
        User user2 = new User(10);
        assertSame("user1 has to be equal to user2.",user1,user2);
        */

        /*
         User user1 = new User(6);
         User user2 = user1;
         assertSame(user1,user2);
         */

        User user1 = new User(6);
        User user2 = new User(6);
        assertEquals(user1,user2);

        /*
        User user1 = new User(6);
        User user2 = new User(15);
        assertEquals("user1 has to be equal to user2.",user1,user2);
        */

        /*
        User user = null;
        assertNull(user);
        */


        /*
        User user = null;
        assertNotNull(user);
         */

        User user = null;
        assertTrue(user==null);

    }

    private static class User{

        private int id;

        public User(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            return this.id == ((User) o).getId();
            //return this == ((User) o);
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            User user = (User) o;
//            return id == user.id;
//        }

    }

}

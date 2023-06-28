package junit;

import org.junit.Ignore;
import org.junit.Test;

public class IgnoreTest {

    @Test
    public void testHello1() throws Exception{
        System.out.println("Hello 1");
    }

    @Test
    @Ignore
    public void testHello2() throws Exception{
        System.out.println("Hello 2");
    }
}

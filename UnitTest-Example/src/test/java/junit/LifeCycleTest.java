package junit;

import org.junit.*;


public class LifeCycleTest {



    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Before Class\n");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("After Class");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Before method");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After method\n");
    }


    @Test
    public void testHelloWorld1(){
        System.out.println("Hello JUnit Test 1 !");
    }

    @Test
    public void testHelloWorld2(){
        System.out.println("Hello JUnit Test 2 !");
    }

}

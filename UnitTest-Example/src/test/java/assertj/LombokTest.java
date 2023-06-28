package assertj;

import org.junit.Test;

public class LombokTest {

    @Test
    public void testLombok() throws Exception{
       // Car car = new Car("Tesla");
        Car car = Car.builder().name("Tesla").build();
        System.out.println(car.toString());
    }

}

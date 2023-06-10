package example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testSum() {
        int num1 = 12;
        int num2 = 21;

        Calculator calculator = new Calculator();
        int result = calculator.sum(num1,num2);

        assertEquals(33,result);

    }

}

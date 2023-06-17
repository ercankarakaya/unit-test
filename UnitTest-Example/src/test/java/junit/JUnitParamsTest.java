package junit;

import example.Calculator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;


@RunWith(JUnitParamsRunner.class)
public class JUnitParamsTest {

    private Calculator calculator = new Calculator();

    @Test
    @Parameters("20,5,100")
    public void testSquareMeterCalculation1(int width,int length,int totalSquareMeter){
           assertEquals(totalSquareMeter,calculator.squareMeterCalculation(width,length));
    }

    @Test
    @Parameters({"20,5,100","40,15,600"})
    public void testSquareMeterCalculation2(int width,int length,int totalSquareMeter){
        assertEquals(totalSquareMeter,calculator.squareMeterCalculation(width,length));
    }
}

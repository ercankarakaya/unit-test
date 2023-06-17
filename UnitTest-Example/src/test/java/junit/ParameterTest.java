package junit;

import example.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParameterTest {

   private Calculator calculator = new Calculator();

    private int width;
    private int length;
    private int totalSquareMeter;

    public ParameterTest(int width, int length, int totalSquareMeter) {
        this.width = width;
        this.length = length;
        this.totalSquareMeter = totalSquareMeter;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {10,30,300},
                {2,10,20},
                {10,10,100}
        });
    }

    @Test
    public void testSquareMeterCalculation(){
         assertEquals(totalSquareMeter,calculator.squareMeterCalculation(width,length));
    }

   /* @Test
    public void testSquareMeterCalculation(){
        assertEquals(300,calculator.squareMeterCalculation(10,30));
    }
    */
}

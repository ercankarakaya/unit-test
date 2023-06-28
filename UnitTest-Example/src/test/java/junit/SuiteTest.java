package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * group testing : Suite
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AssertTest.class,
        LifeCycleTest.class,
        ParameterTest.class,
        JUnitParamsTest.class
})
public class SuiteTest {


}

package assertj;

import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomTest {

    List<String> citiesA = Arrays.asList("New York","Paris","Istanbul");
    List<String> citiesB = Arrays.asList("London","Berlin","Rome");

    @Test
    public void testStrings(){

        String text1 = "Istanbul";

        assertThat(text1)
                .describedAs("This is a error!")
                .isEqualTo("Istanbul")
                .startsWith("Ist")
                .endsWith("bul")
                .contains("tan")
                .isNotEmpty()
                .isNotNull()
                .doesNotContain("ercan")
                .containsOnlyOnce("tan");
    }

    @Test
    public void testLists(){

        assertThat(citiesA)
                .describedAs("This is a error!")
                .contains("Paris")
                .doesNotContain("Moscow")
                .containsExactly("New York","Paris","Istanbul")
                .doesNotHaveDuplicates();

        // for citiesA list
        List<String> cities1 = Arrays.asList("New York","Paris","Istanbul");

        assertThat(cities1)
                .have(citiesA());

        // for citiesB list
        List<String> cities2 = Arrays.asList("London","Berlin","Rome");

        assertThat(cities2)
                .have(citiesB());

        // 2 city A and 3 city B
        List<String> cities3 = Arrays.asList("Paris","Berlin","New York","London","Rome");

        assertThat(cities3)
                .haveExactly(2,citiesA())  // 2 times A cities
                .haveExactly(3,citiesB()); // 3 times B cities


    }

    private Condition<? super String> citiesA() {
        return new Condition<String>() {
            @Override
            public boolean matches(String s) {
                return citiesA.contains(s);
            }
        };
    }

    private Condition<? super String> citiesB(){
        return new Condition<String>() {
            @Override
            public boolean matches(String s) {
                return citiesB.contains(s);
            }
        };
    }

}

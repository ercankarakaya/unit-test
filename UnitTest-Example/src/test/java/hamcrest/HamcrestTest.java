package hamcrest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class HamcrestTest {

    @Test
    public void testBasicPairings() throws Exception{
        String text1="Ercan";
        String text2="Ali";

        assertEquals("Ercan",text1);

        //org.junit.Assert.assertThat  &&  org.hamcrest.CoreMatchers.*
        assertThat(text1,is(equalTo("Ercan")));

        assertThat(text1,is(notNullValue()));

        assertThat(text1,containsString("an"));

        assertThat(text1,anyOf(containsString("an"),containsString("ka"))); // anyOf -> or
    }

    @Test
    public void testLists() throws Exception{
        List<String> cities = Arrays.asList("New York","Paris","Istanbul");

        assertThat(cities,hasItem("Paris"));

        assertThat(cities,hasItems("Paris","New York"));

        assertThat(cities,allOf(hasItems("New York","Paris"),not(hasItem("Moscow"))));  // allOf -> and and

        assertThat(cities,either(hasItems("New York","Paris")).or(not(hasItem("Moscow")))); // either or -> or or
    }

}

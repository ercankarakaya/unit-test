package assertj;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class CustomListTest {


    @Test
    public void testLists() throws Exception{

        List<Item> items = new ArrayList<>();
        items.add(new Item(1,"david"));
        items.add(new Item(2,"john"));
        items.add(new Item(3,"micheal"));
        items.add(new Item(4,"bob"));
        items.add(new Item(5,"olivia"));

        assertThat(items)
                .extracting("name")
                        .contains("david","micheal");

        assertThat(items)
                .extracting("id")
                .contains(2,4);

        assertThat(items)
                .extracting("name","id")
                .contains(
                        tuple("bob",4),
                        tuple("olivia",5)
                );

        assertThat(
                extractProperty("id",Integer.class).from(items)
        ).containsExactly(1,2,3,4,5);

    }


    @Data
    @AllArgsConstructor
    static class Item {

        private Integer id;
        private String name;
    }
}

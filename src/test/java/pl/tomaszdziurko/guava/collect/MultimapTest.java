package pl.tomaszdziurko.guava.collect;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Test class for Multimap
 */

@Test
public class MultimapTest {

    @Test
    public void shouldTestHowMultimapWorks() throws Exception {

        // given
        Multimap<String, String> multimap = ArrayListMultimap.create();

        // when
        multimap.put("Poland", "Warsaw");
        multimap.put("Poland", "Cracow");
        multimap.put("Poland", "Plock");
        multimap.put("Poland", "Gdansk");

        multimap.put("Germany", "Berlin");
        multimap.put("Germany", "Bremen");
        multimap.put("Germany", "Dortmund");
        multimap.put("Germany", "Koln");

        multimap.put("Portugal", "Lisbone");
        multimap.put("Portugal", "Porto");
        multimap.put("Portugal", "Leira");
        multimap.put("Portugal", "Funchal");
        multimap.put("Portugal", "Funchal");


        // then
        assertThat(multimap.get("Poland").size()).isEqualTo(4);
        assertThat(multimap.get("Portugal").size()).isEqualTo(5); // duplicate values are fine
        assertThat(multimap.get("Poland")).contains("Warsaw", "Plock");
        assertThat(multimap.keys().size()).isEqualTo(13); // keys can have duplicates

    }

}

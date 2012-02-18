package pl.tomaszdziurko.guava.collect;

import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * ForwardingListTest showcase
 */
public class ForwardingListTest {

    @Test
    public void shouldAddOppositeNumber() throws Exception {

        // given
        Collection<Integer> numbersList = new ForwardingCollection<Integer>() {
            private List<Integer> list = Lists.newArrayList();

            @Override
            protected List<Integer> delegate() {
                return list;
            }

            @Override
            public boolean add(Integer element) {
                if(element == null) {
                    return super.add(element);
                }
                if(element.intValue() == 0) {
                    return super.add(element);
                }
                else {
                    return super.add(element) && super.add(-element);
                }
            }

            @Override
            public boolean addAll(Collection<? extends Integer> integers) {
                if(integers == null) {
                    return add(null);
                }
                boolean result = true;
                for (Integer element : integers) {
                    result = result && add(element);
                }
                return result;
            }
        };

        numbersList.add(10);
        numbersList.add(12);
        numbersList.add(0);
        numbersList.add(null);

        assertThat(numbersList).containsOnly(10, 12, -10, -12, 0, null);

    }
}

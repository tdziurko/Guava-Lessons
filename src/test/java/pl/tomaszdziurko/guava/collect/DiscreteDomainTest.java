package pl.tomaszdziurko.guava.collect;

import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.DiscreteDomains;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Showcas of discrete domains interface
 */
public class DiscreteDomainTest {
    

    @Test
    public void shouldReturnNextInt() throws Exception {

        // given
        DiscreteDomain<Integer> integers = DiscreteDomains.integers();

        // when
        Integer next = integers.next(new Integer(100));

        // then
        assertThat(next).isEqualTo(101);
    }

    @Test
    public void shouldReturnPreviousInt() throws Exception {

        // given
        DiscreteDomain<Integer> integers = DiscreteDomains.integers();

        // when
        Integer next = integers.previous(new Integer(100));

        // then
        assertThat(next).isEqualTo(99);
    }

    @Test
    public void shouldReturnDistance() throws Exception {

        // given
        DiscreteDomain<Integer> integers = DiscreteDomains.integers();

        // when
        long distance = integers.distance(100, 150);

        // then
        assertThat(distance).isEqualTo(50L);
    }

    @Test
    public void shouldReturnMaxAndMinInt() throws Exception {

        // given
        DiscreteDomain<Integer> integers = DiscreteDomains.integers();

        // when
        long min = integers.minValue();
        long max = integers.maxValue();

        // then
        assertThat(min).isEqualTo(Integer.MIN_VALUE);
        assertThat(max).isEqualTo(Integer.MAX_VALUE);
    }
}

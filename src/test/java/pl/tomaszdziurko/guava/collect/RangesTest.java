package pl.tomaszdziurko.guava.collect;

import com.google.common.collect.DiscreteDomains;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.collect.Ranges;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Range and Ranges showcase
 */
public class RangesTest {

    @Test
    public void shouldCheckThatElementIsInRange() throws Exception {

        // given
        Range<Integer> range = Ranges.closed(2, 20);
        Range<Integer> rangeWithRightOpen = Ranges.closedOpen(2, 20);

        // then
        assertThat(range.contains(20)).isTrue();
        assertThat(rangeWithRightOpen.contains(20)).isFalse();
    }

    @Test
    public void shouldCheckThatRangeIsEnclosedInAnotherOne() throws Exception {

        // given
        Range<Long> range = Ranges.openClosed(10L, 20L);
        Range<Long> smallerRange = Ranges.closed(10L, 15L);

        // then
        assertThat(range.encloses(smallerRange)).isFalse();
    }

    @Test
    public void shouldCheckThatAllElementAreInRange() throws Exception {

        // given
        Range<Integer> range = Ranges.closed(2, 20);

        // then
        assertThat(range.containsAll(Lists.newArrayList(3, 4, 5, 6, 7, 8, 9, 10))).isTrue();
    }

    @Test
    public void shouldGenerateSetOfElementsInRange() throws Exception {

        // given
        Range<Integer> range = Ranges.open(2, 20);

        // when
        Set<Integer> integersInRange = range.asSet(DiscreteDomains.integers());

        // then
        assertThat(integersInRange).contains(3);
        assertThat(integersInRange).contains(19);
        assertThat(integersInRange).excludes(2, 20);
    }

    @Test
    public void shouldCreateRangeForGivenNumbers() throws Exception {

        // given
        ArrayList<Integer> numbers = Lists.newArrayList(4, 3, 10, 30, 20);

        // when
        Range<Integer> range = Ranges.encloseAll(numbers);

        // then
        assertThat(range.lowerEndpoint()).isEqualTo(3);
        assertThat(range.upperEndpoint()).isEqualTo(30);
    }
}

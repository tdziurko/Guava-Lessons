package pl.tomaszdziurko.guava.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.fail;

/**
 * Constraints showcase
 */
public class ConstraintsTest {

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldThrowExceptionOnNullAdd() throws Exception {

        // given
        List<Integer> numbers = Constraints
                .constrainedList(Lists.newArrayList(1, 2, 3), Constraints.<Integer>notNull());

        // when
        numbers.add(null);

        // then
        fail("Should throw a NullPointerException");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionOnInvalidAdd() throws Exception {

        // given
        List<Integer> userAgesList = Constraints.constrainedList(Lists.newArrayList(1, 2, 3), new Constraint<Integer>() {

            @Override
            public Integer checkElement(Integer age) {
                Preconditions.checkNotNull(age);
                Preconditions.checkArgument(age.intValue() > 0);
                return age;
            }
        });

        // when
        userAgesList.add(-2);

        // then
        fail("Should throw a IllegalArgumentException");
    }
}

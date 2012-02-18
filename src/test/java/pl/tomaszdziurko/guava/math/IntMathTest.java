package pl.tomaszdziurko.guava.math;

import com.google.common.math.IntMath;
import org.testng.annotations.Test;

import java.math.RoundingMode;

import static org.fest.assertions.Assertions.assertThat;

/**
 * com.google.common.math package showcase with IntMath as an example
 */
public class IntMathTest {

    @Test(expectedExceptions = ArithmeticException.class, expectedExceptionsMessageRegExp = "overflow")
    public void shouldThrowExceptionWhenOverflow() throws Exception {

        // given
        int numberOne = Integer.MAX_VALUE - 4;
        int numberTwo = 6;

        // when
        int resultOldWay = numberOne + numberTwo;

        // silent overflow here
        assertThat(resultOldWay).isEqualTo(Integer.MIN_VALUE + 1);
        
        int result = IntMath.checkedAdd(numberOne, numberTwo);
    }

    @Test
    public void shouldDivideWithRoundingMode() throws Exception {

        // when
        int roundedUp = IntMath.divide(10, 4, RoundingMode.HALF_UP);
        int roundedDown = IntMath.divide(10, 4, RoundingMode.HALF_DOWN);

        // then
        assertThat(roundedUp).isEqualTo(3);
        assertThat(roundedDown).isEqualTo(2);
    }

    @Test
    public void shouldCalculateFactorial() throws Exception {
        // when
        int factorial = IntMath.factorial(5);

        // then
        assertThat(factorial).isEqualTo(1 * 2 * 3 * 4 * 5);
    }

    @Test
    public void shouldCalculateGreatestCommonDivisor() throws Exception {
        // when
        int gcd = IntMath.gcd(20, 15);

        // then
        assertThat(gcd).isEqualTo(5);
    }

    @Test
    public void shouldCalculateLogarithms() throws Exception {

        // when
        int log2Result = IntMath.log2(17, RoundingMode.HALF_UP);
        int log10Result = IntMath.log10(100, RoundingMode.UNNECESSARY);

        // then
        assertThat(log2Result).isEqualTo(4);
        assertThat(log10Result).isEqualTo(2);
    }
    
}

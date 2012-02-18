package pl.tomaszdziurko.guava.primitives;

import com.google.common.primitives.Ints;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Class showing features of one of primitves class from Guava: Ints
 */
public class PrimitivesTest {



    @Test
    public void shouldFindGivenNumberInArray() throws Exception {

        assertThat(Ints.contains(array, 22)).isTrue();
    }

    @Test
    public void shouldFindIndexOfGivenNumber() throws Exception {

        assertThat(Ints.indexOf(array, 5)).isEqualTo(0);
    }

    final int[] array2 = new int[] {0, 14, 99};



    @Test
    public void shouldConcatArrays() throws Exception {
        assertThat(Ints.concat(array, array2).length).isEqualTo(array.length + array2.length);
    }

    @Test
    public void shouldJoinArrayUsingSeparator() throws Exception {
        assertThat(Ints.join(":", array2)).isEqualTo("0:14:99");
    }

    final int[] array = new int[] {5, 2, 4, -12, 100, 450, 22, 7};

    @Test
    public void shouldFindMaxAndMinInArray() throws Exception {

       assertThat(Ints.min(array)).isEqualTo(-12);
       assertThat(Ints.max(array)).isEqualTo(450);

    }


}

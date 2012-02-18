package pl.tomaszdziurko.guava.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Class to show some features of Splitter class
 */
public class SplitterTest {

    public static String textWithDigitsAsADelimeter = "Java1Scala2Haskell3444Brainfuck452Kotlin";
    public static String textWithDigitsFrom3To5AsADelimeter = "Java3Scala4Haskell0Brainfuck5Kotlin";
    public static String textWithFiveCharactersWords = "HorseHouseGroupDemosScrum";

    public static String textWithSemicolonAsADelimeterWithEmptyElementsAndSpaces = "Java;;  ;Scala;;;Haskell;Brainfuck;Kotlin";


    @Test
    public void shouldSplitOnSemicolons() throws Exception {
        // when
        Iterable<String> iterable = Splitter.on(";").split("Java;Scala;Haskell;Brainfuck;Kotlin");
        List<String> splittedList = convertToList(iterable.iterator());

        // then
        assertThat(splittedList.size()).isEqualTo(5);
        assertThat(splittedList.get(3)).isEqualTo("Brainfuck");
    }

    private List<String> convertToList(Iterator<String> iterator) {
        List<String> list = Lists.newArrayList( );

        while(iterator.hasNext()) {
            list.add(iterator.next());
        }

        return list;
    }

    @Test
    public void shouldSplitOnRegExp() throws Exception {
        // when
        Iterable<String> iterable = Splitter.onPattern("\\d+").split("Java3Scala4Haskell0Brainfuck5Kotlin");
        List<String> splittedList = convertToList(iterable.iterator());

        // then
        assertThat(splittedList.size()).isEqualTo(5);
        assertThat(splittedList.get(2)).isEqualTo("Haskell");
    }



    @Test
    public void shouldSplitUsingCharMatcher() throws Exception {

        // when
        Iterable<String> iterable = Splitter
                .on(CharMatcher.inRange('3', '5')).split("Java3Scala4Haskell0Brainfuck5Kotlin");
        List<String> splittedList = convertToList(iterable.iterator());

        // then
        assertThat(splittedList.size()).isEqualTo(4);
        assertThat(splittedList.get(2)).isEqualTo("Haskell0Brainfuck");

    }

    @Test
    public void shouldSplitAndOmitEmptyElementsAndWhitespaces() throws Exception {
        // when
        Iterable<String> iterable = Splitter.on(";").omitEmptyStrings()
                .trimResults().split("Java;;  ;Scala;;;Haskell;Brainfuck;Kotlin");
        List<String> splittedList = convertToList(iterable.iterator());

        // then
        assertThat(splittedList.size()).isEqualTo(5);
        assertThat(splittedList.get(1)).isEqualTo("Scala");

    }

    @Test
    public void shouldSplitForEqualLength() throws Exception {

        // when
        Iterable<String> iterable = Splitter.fixedLength(5).split("HorseHouseGroupDemosScrum");
        List<String> splittedList = convertToList(iterable.iterator());

        // then
        assertThat(splittedList.size()).isEqualTo(5);
        assertThat(splittedList.get(4)).isEqualTo("Scrum");
    }
}

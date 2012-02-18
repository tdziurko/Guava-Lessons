package pl.tomaszdziurko.guava.base;

import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Class showing how Stopwatch works
 */
public class StopwatchTest {

    @Test
    public void shouldCalculateIterationsTime() throws Exception {

        // given
        Ticker ticker = mock(Ticker.class);
        when(ticker.read()).thenReturn(0L, 2000000000L);
        Stopwatch stopwatch = new Stopwatch(ticker);

        // when
        stopwatch.start();
        // some method is called here
        stopwatch.stop();

        // then
        assertThat(stopwatch.elapsedMillis()).isEqualTo(2000L);
    }

    @Test
    public void shouldPrintIterationsTime() throws Exception {

        // given
        Ticker ticker = mock(Ticker.class);
        when(ticker.read()).thenReturn(0L, 2*60*60*1000000000L); // 2 hours
        Stopwatch stopwatch = new Stopwatch(ticker);

        // when
        stopwatch.start();
        // some method is called here
        stopwatch.stop();

        // then
        assertThat(stopwatch.toString()).isEqualTo("7200 s");
        assertThat(stopwatch.elapsedTime(TimeUnit.MINUTES)).isEqualTo(120);
        assertThat(stopwatch.elapsedTime(TimeUnit.HOURS)).isEqualTo(2);
    }

}

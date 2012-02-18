package pl.tomaszdziurko.guava.base;

import com.google.common.base.Charsets;
import org.testng.annotations.Test;

import java.nio.charset.Charset;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Classs to show how to use Charsets class
 */
public class CharsetsTest {

    @Test
    public void shouldCreateSupportedInJavaCharset() throws Exception {

        // given
        Charset charset = Charset.forName("UTF-8");

        // when
        Charset charsetFromGuava = Charsets.UTF_8;

        // then
        assertThat(charset.name()).isEqualTo(charsetFromGuava.name());
    }
}

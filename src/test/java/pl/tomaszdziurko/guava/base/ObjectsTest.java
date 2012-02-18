package pl.tomaszdziurko.guava.base;


import org.testng.annotations.Test;
import pl.tomaszdziurko.guava.UserProfile;

import static org.fest.assertions.Assertions.assertThat;

@Test
public class ObjectsTest {

    UserProfile objectsLesson = new UserProfile("name", "nickname", 20);
    UserProfile objectsLesson2 = new UserProfile("name", "nickname", 20);
    UserProfile nullNicknameObject = new UserProfile("name", null, 20);

    @Test
    public void shouldTestEquals() throws Exception {

        assertThat(objectsLesson).isEqualTo(objectsLesson2);
    }

    @Test
    public void shouldTestHashcode() throws Exception {

        assertThat(objectsLesson.hashCode()).isEqualTo(objectsLesson2.hashCode());
    }

    @Test
    public void shouldRenderNameAsDisplayableName() throws Exception {

        // then
        assertThat(nullNicknameObject.getDisplayName()).isEqualTo("name");
    }

    @Test
    public void shouldShowHowToStringMethodWorks() throws Exception {

        assertThat(objectsLesson.toString())
                .isEqualTo("UserProfile{name=name, nickname=nickname, 20}");

    }
}

package pl.tomaszdziurko.guava;

import com.google.common.base.Objects;

/**
 * Class to play with some features from Objects class
 */
public class UserProfile {

    private String name;
    private String nickname;
    private Integer age;

    public UserProfile(String name, String nickname, Integer age) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserProfile)) return false;

        UserProfile objectsLesson = (UserProfile) o;
        return Objects.equal(this.name, objectsLesson.name) &&
                Objects.equal(this.age, objectsLesson.age) &&
                Objects.equal(this.nickname, objectsLesson.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age, nickname);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", name)
                .add("nickname", nickname)
                .addValue(age).toString();
    }

    public String getDisplayName() {
        return Objects.firstNonNull(nickname, name);
    }
}

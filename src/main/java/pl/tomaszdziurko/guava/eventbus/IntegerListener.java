package pl.tomaszdziurko.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * Class listening for Integers
 */
public class IntegerListener {

    private Integer lastMessage;

    @Subscribe
    public void listen(Integer integer) {
        lastMessage = integer;
    }

    public Integer getLastMessage() {
        return lastMessage;
    }
}

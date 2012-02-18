package pl.tomaszdziurko.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * Listener waiting for Number class events
 */
public class NumberListener {

    private Number lastMessage;

    @Subscribe
    public void listen(Number integer) {
        lastMessage = integer;
    }

    public Number getLastMessage() {
        return lastMessage;
    }
}

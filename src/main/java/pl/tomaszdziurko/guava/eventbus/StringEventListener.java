package pl.tomaszdziurko.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * String event listener
 */
public class StringEventListener {


    public String lastMessage;

    @Subscribe
    public void listen(StringTestEvent event) {
        lastMessage = event.getMessage();
    }

    public String getLastMessage() {
        return lastMessage;
    }
}

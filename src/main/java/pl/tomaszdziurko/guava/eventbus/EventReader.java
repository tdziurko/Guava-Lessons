package pl.tomaszdziurko.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * Another class which can subscribe to events
 */
public class EventReader {
    
    public int lastMessage = 0;

    @Subscribe
    public void read(OurTestEvent event) {
        lastMessage = event.getMessage();
    }

    public int getLastMessage() {
        return lastMessage;
    }
}

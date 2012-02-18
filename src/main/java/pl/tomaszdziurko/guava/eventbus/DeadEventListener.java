package pl.tomaszdziurko.guava.eventbus;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * Listener waiting for the event that any message was posted but not delivered to anyone
 */
public class DeadEventListener {

    boolean notDelivered = false;

    @Subscribe
    public void listen(DeadEvent event) {
        notDelivered = true;
    }

    public boolean isNotDelivered() {
        return notDelivered;
    }
}



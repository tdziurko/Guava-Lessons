package pl.tomaszdziurko.guava.eventbus;

/**
 * Test event class
 */
public class OurTestEvent {
    
    private final int message;

    public OurTestEvent(int message) {
        this.message = message;
    }

    public int getMessage() {
        return message;
    }

}

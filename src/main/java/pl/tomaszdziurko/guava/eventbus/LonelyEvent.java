package pl.tomaszdziurko.guava.eventbus;

/**
 * Event without listeners
 */
public class LonelyEvent {
    
    private String message;

    public LonelyEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}


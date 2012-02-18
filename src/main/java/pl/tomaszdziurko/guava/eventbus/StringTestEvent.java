package pl.tomaszdziurko.guava.eventbus;

/**
 * Event with String as a message
 */
public class StringTestEvent {
    
    private String message;

    public String getMessage() {
        return message;
    }

    public StringTestEvent(String message) {

        this.message = message;
    }
}

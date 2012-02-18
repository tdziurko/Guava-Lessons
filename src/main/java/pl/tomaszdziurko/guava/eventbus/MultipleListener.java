package pl.tomaszdziurko.guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class MultipleListener {

    public Integer lastInteger;
    public Long lastLong;

    @Subscribe
    public void listenInteger(Integer event) {
        lastInteger = event;
    }

    @Subscribe
    public void listenLong(Long event) {
        lastLong = event;
    }

    public Integer getLastInteger() {
        return lastInteger;
    }

    public Long getLastLong() {
        return lastLong;
    }
}

package pl.tomaszdziurko.guava.eventbus;

import com.google.common.eventbus.EventBus;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Events subscribe and publish showcase
 */
public class EventBusTest {

    @Test
    public void shouldReceiveEvent() throws Exception {

        // given
        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();

        eventBus.register(listener);

        // when
        eventBus.post(new OurTestEvent(200));

        // then
        assertThat(listener.getLastMessage()).isEqualTo(200);
    }

    @Test
    public void shouldReceiveMultipleEvents() throws Exception {

        // given
        EventBus eventBus = new EventBus("test");
        MultipleListener multiListener = new MultipleListener();

        eventBus.register(multiListener);


        // when
        eventBus.post(new Integer(100));
        eventBus.post(new Long(800));

        // then
        assertThat(multiListener.getLastInteger()).isEqualTo(100);
        assertThat(multiListener.getLastLong()).isEqualTo(800L);
    }

    @Test
    public void shouldReceiveMultipleEventTypesFromBus() throws Exception {

        // given
        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();
        EventReader reader = new EventReader();
        StringEventListener stringEventListener = new StringEventListener();

        eventBus.register(listener);
        eventBus.register(reader);
        eventBus.register(stringEventListener);

        // when
        eventBus.post(new OurTestEvent(200));
        eventBus.post(new StringTestEvent("Hello events!"));


        // then
        assertThat(reader.getLastMessage()).isEqualTo(200);
        assertThat(listener.getLastMessage()).isEqualTo(200);
        assertThat(stringEventListener.getLastMessage()).isEqualTo("Hello events!");
    }

    @Test
    public void shouldNotReceiveEventAfterUnsubscribe() throws Exception {

        // given
        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();
        EventReader reader = new EventReader();

        eventBus.register(listener);
        eventBus.register(reader);

        // when
        eventBus.post(new OurTestEvent(200));


        // then
        assertThat(reader.getLastMessage()).isEqualTo(200);
        assertThat(listener.getLastMessage()).isEqualTo(200);
        
        
        //when 
        eventBus.unregister(reader);
        eventBus.post(new OurTestEvent(300));


        // then
        assertThat(listener.getLastMessage()).isEqualTo(300);
        // this one was unregistered
        assertThat(reader.getLastMessage()).isEqualTo(200);
    }

    @Test
    public void shouldDetectEventWithoutListeners() throws Exception {

        // given
        EventBus eventBus = new EventBus("test");

        DeadEventListener deadEventListener = new DeadEventListener();
        eventBus.register(deadEventListener);

        // when
        eventBus.post(new OurTestEvent(200));

        assertThat(deadEventListener.isNotDelivered()).isTrue();
    }

    @Test
    public void shouldGetEventsFromSubclass() throws Exception {

        // given
        EventBus eventBus = new EventBus("test");
        IntegerListener integerListener = new IntegerListener();
        NumberListener numberListener = new NumberListener();
        eventBus.register(integerListener);
        eventBus.register(numberListener);

        // when
        eventBus.post(new Integer(100));

        // then
        assertThat(integerListener.getLastMessage()).isEqualTo(100);
        assertThat(numberListener.getLastMessage()).isEqualTo(100);

        //when
        eventBus.post(new Long(200L));

        // then
        // this one should has the old value as it listens only for Integers
        assertThat(integerListener.getLastMessage()).isEqualTo(100);
        assertThat(numberListener.getLastMessage()).isEqualTo(200L);
    }
}

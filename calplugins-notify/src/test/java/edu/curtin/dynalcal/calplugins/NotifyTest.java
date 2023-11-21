package edu.curtin.dynalcal.calplugins;

import edu.curtin.dynacal.api.IEvent;
import edu.curtin.dynacal.api.IEventHandler;
import edu.curtin.dynacal.calplugins.Notify;
import org.junit.jupiter.api.Test;
import edu.curtin.dynacal.api.API;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotifyTest {
    @Test
    void testStart() {
        Notify notify = new Notify();
        APIMock api = new APIMock("Test Event");
        Map<String, String> parameters = new HashMap<>();

        parameters.put("title", "Test Event");

        notify.start(api, parameters);

        api.triggerEvent("Test Event");

        assertTrue(OptionPaneMock.isMessageDisplayed());
    }

    private static class APIMock implements API {
        private String eventName;
        private IEvent event;
        private IEventHandler eventHandler;

        public APIMock(String eventName) {
            this.eventName = eventName;
        }

        @Override
        public void registerEvent(IEvent event) {
            this.event = event;
        }

        @Override
        public void registerEventHandler(IEventHandler eventHandler) {
            this.eventHandler = eventHandler;
        }

        public void triggerEvent(String eventName) {
            OptionPaneMock.showMessageDialog(new EventMock(eventName));
        }
    }

    private static class EventMock implements IEvent {
        private String eventName;

        public EventMock(String eventName) {
            this.eventName = eventName;
        }

        @Override
        public String getName() {
            return eventName;
        }

        @Override
        public LocalDate getStartDate() {
            return null;
        }

        @Override
        public Optional<LocalTime> getStartTime() {
            return Optional.empty();
        }

        @Override
        public Optional<Integer> getDuration() {
            return Optional.empty();
        }
    }

    private static class OptionPaneMock extends JOptionPane {
        private static boolean messageDisplayed = false;

        public static void showMessageDialog(Object message) {
            messageDisplayed = true;
        }

        public static boolean isMessageDisplayed() {
            return messageDisplayed;
        }

        public static void messageIsDisplayed() {
            messageDisplayed = true;
        }
    }
}

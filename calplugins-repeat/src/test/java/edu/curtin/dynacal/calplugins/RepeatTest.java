package edu.curtin.dynacal.calplugins;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.IEvent;
import edu.curtin.dynacal.api.IEventHandler;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatTest {
    @Test
    public void testStart() {
        APIMock api = new APIMock();
        Repeat repeat = new Repeat();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Map<String, String> parameters = new HashMap<>();

        parameters.put("title", "Test");
        parameters.put("startDate", LocalDate.now().format(dateFormatter));
        parameters.put("repeat", "7");

        repeat.start(api, parameters);

        assert(api.getRegisteredEvent() != null);
        assertEquals(53, api.getRegisteredEvents().size());
    }

    private static class APIMock implements API {
        private IEvent event;
        private List<IEvent> events;

        public APIMock() {
            events = new ArrayList<>();
        }

        @Override
        public void registerEvent(IEvent event) {
            this.event = event;
            events.add(event);
        }

        @Override
        public void registerEventHandler(IEventHandler eventHandler) {
            // Implement Not Needed
        }

        public IEvent getRegisteredEvent() {
            return event;
        }

        public List<IEvent> getRegisteredEvents() {
            return events;
        }
    }

}

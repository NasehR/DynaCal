package edu.curtin.dynacal.app;

import edu.curtin.dynacal.api.IEvent;
import org.junit.jupiter.api.Test;
import edu.curtin.dynacal.dsl.CalendarParser;
import edu.curtin.dynacal.dsl.ParseException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UTF8Test {

    @Test
    public void testParserUTF8() {
        List<IEvent> eventList = List.of();
        Map<String, Map<String, String>> plugInInfo = Map.of();
        CalendarParser p;

        try {
            p = CalendarParser.parse("calendar.utf8.cal", "UTF-8");
            eventList = p.getEventList();
            plugInInfo = p.getPlugInInfo();
        } catch (ParseException parseException) {
            System.out.println(parseException.toString());
        } catch (IOException ioException) {
            System.out.println(ioException.toString());
        }

        assertEquals("Meeting 1", eventList.get(0).getName(), "Event name is not correct");
        assertEquals("Meeting 1", eventList.get(1).getName(), "Event name is not correct");
        assertEquals(6, eventList.size());

        assertEquals(2, plugInInfo.size());
        assertEquals("Meeting 4",
                plugInInfo.get("edu.curtin.dynacal.calplugins.Notify").get("title"));


        assertEquals("These meeting",
                plugInInfo.get("edu.curtin.dynacal.calplugins.Repeat")
                        .get("title"));

        assertEquals("01/12/2023",
                plugInInfo.get("edu.curtin.dynacal.calplugins.Repeat")
                        .get("startDate"));

        assertEquals("10:00:00",
                plugInInfo.get("edu.curtin.dynacal.calplugins.Repeat")
                        .get("startTime"));

        assertEquals("60",
                plugInInfo.get("edu.curtin.dynacal.calplugins.Repeat")
                        .get("duration"));

        assertEquals("7",
                plugInInfo.get("edu.curtin.dynacal.calplugins.Repeat")
                        .get("repeat"));
    }
}

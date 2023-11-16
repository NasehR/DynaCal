package edu.curtin.dynacal.app.controller;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.IEvent;
import java.util.List;

public class CalendarController implements API {
    private List<IEvent> eventsList;

    public CalendarController(List<IEvent> eventsList) {
        this.eventsList = eventsList;
    }

    @Override
    public void registerEvent(IEvent event) {
        eventsList.add(event);
    }
}

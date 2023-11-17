package edu.curtin.dynacal.app.model;

import edu.curtin.dynacal.api.IEvent;

import java.util.ArrayList;
import java.util.List;

public class EventsModel {
    private List<IEvent> eventsList;

    public EventsModel(List<IEvent> eventsList) {
        this.eventsList =  eventsList;
    }

    public void addEvent(IEvent event) {
        eventsList.add(event);
    }

    public List<IEvent> getEventsList() {
        return eventsList;
    }
}

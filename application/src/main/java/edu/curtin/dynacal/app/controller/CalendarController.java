package edu.curtin.dynacal.app.controller;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.IEvent;

import java.util.ArrayList;
import java.util.List;

public class CalendarController implements API {
    private List<IEvent> eventsList;
    private List<IEventListener> listeners;

    public CalendarController(List<IEvent> eventsList) {
        this.eventsList = eventsList;
        listeners = new ArrayList<>();
    }

    @Override
    public void registerEvent(IEvent event) {
        eventsList.add(event);
    }

    public void addListener(IEventListener listener) {
        listeners.add(listener);
    }
}

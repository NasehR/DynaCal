package edu.curtin.dynacal.app.controller;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.IEvent;
import edu.curtin.dynacal.api.IEventHandler;

import java.util.ArrayList;
import java.util.List;

public class CalendarController implements API {
    private List<IEvent> eventsList;
    private List<IEventHandler> handlers;

    public CalendarController(List<IEvent> eventsList) {
        this.eventsList = eventsList;
        handlers = new ArrayList<>();
    }

    @Override
    public void registerEvent(IEvent event) {
        eventsList.add(event);
    }

    @Override
    public void registerEventHandler(IEventHandler eventHandler) {
        handlers.add(eventHandler);
    }
}

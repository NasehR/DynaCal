package edu.curtin.dynacal.app.controller;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.IEvent;
import edu.curtin.dynacal.api.IEventHandler;
import edu.curtin.dynacal.app.model.EventsModel;

import java.util.ArrayList;
import java.util.List;

public class CalendarController implements API {
    private List<IEvent> eventsList;
    private List<IEventHandler> handlers;
    private EventsModel eventsModel;

    public CalendarController(EventsModel eventsModel) {
        this.eventsModel = eventsModel;
        handlers = new ArrayList<>();
    }

    @Override
    public void registerEvent(IEvent event) {
        eventsModel.addEvent(event);
    }

    @Override
    public void registerEventHandler(IEventHandler eventHandler) {
        handlers.add(eventHandler);
    }
}

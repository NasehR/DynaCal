package edu.curtin.dynacal.app.controller;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.IEvent;
import edu.curtin.dynacal.api.IEventHandler;
import edu.curtin.dynacal.app.model.EventsModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarController implements API {
    private List<IEventHandler> handlers;
    private EventsModel eventsModel;
    private LocalDate viewDate;

    public CalendarController(EventsModel eventsModel) {
        this.eventsModel = eventsModel;
        handlers = new ArrayList<>();
        viewDate = LocalDate.now();
    }

    @Override
    public void registerEvent(IEvent event) {
        eventsModel.addEvent(event);
    }

    @Override
    public void registerEventHandler(IEventHandler eventHandler) {
        handlers.add(eventHandler);
    }

    public List<IEvent> getEventsList() {
        return eventsModel.getEventsList();
    }

    public LocalDate getViewDate() {
        return viewDate;
    }
    public void setViewDate(LocalDate viewDate) {
        this.viewDate = viewDate;
    }
}

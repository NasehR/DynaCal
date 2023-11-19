package edu.curtin.dynacal.app.controller;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.IEvent;
import edu.curtin.dynacal.api.IEventHandler;
import edu.curtin.dynacal.app.model.EventsModel;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarController implements API {
    private final List<IEventHandler> handlers;
    private final EventsModel eventsModel;
    private LocalDate viewDate;
    private Thread myThread;

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

    public void pollTime() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                LocalDate currentDate = LocalDate.now();
                LocalTime currentTime = LocalTime.now();

                List<IEvent> eventsList = eventsModel.getEventsList();

                eventsList.stream()
                        .filter((event) -> event.getStartDate()
                                .equals(currentDate))
                        .filter((event) -> event.getStartTime()
                                .isPresent() && event
                                .getStartTime()
                                .get()
                                .getHour() == currentTime.getHour())
                        .forEach((event) -> handlers
                                .forEach((handler) -> handler
                                        .eventStarted(event))
                        );
            }
        };

        myThread = new Thread(task);
        myThread.start();
    }

    public void stopTime() {
        myThread.interrupt();
    }
}

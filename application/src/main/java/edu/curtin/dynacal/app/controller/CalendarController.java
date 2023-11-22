package edu.curtin.dynacal.app.controller;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.IEvent;
import edu.curtin.dynacal.api.IEventHandler;
import edu.curtin.dynacal.app.model.EventsModel;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for managing calendar events and handling time polling.
 */
public class CalendarController implements API {
    // Class fields
    private final List<IEventHandler> handlers;
    private final EventsModel eventsModel;
    private LocalDate viewDate;
    private Thread myThread;

    /**
     * Constructor to initialize CalendarController with an EventsModel.
     *
     * @param eventsModel The model responsible for managing calendar events.
     */
    public CalendarController(EventsModel eventsModel) {
        this.eventsModel = eventsModel;
        handlers = new ArrayList<>();
        viewDate = LocalDate.now();
    }

    /**
     * Registers a calendar event.
     *
     * @param event The event to be registered.
     */
    @Override
    public void registerEvent(IEvent event) {
        eventsModel.addEvent(event);
    }

    /**
     * Registers an event handler for calendar events.
     *
     * @param eventHandler The event handler to be registered.
     */
    @Override
    public void registerEventHandler(IEventHandler eventHandler) {
        handlers.add(eventHandler);
    }

    /**
     * Gets the list of calendar events.
     *
     * @return List of calendar events.
     */
    public List<IEvent> getEventsList() {
        return eventsModel.getEventsList();
    }

    /**
     * Gets the current view date.
     *
     * @return The current view date.
     */
    public LocalDate getViewDate() {
        return viewDate;
    }

    /**
     * Sets the view date for the calendar.
     *
     * @param viewDate The date to be set as the view date.
     */
    public void setViewDate(LocalDate viewDate) {
        this.viewDate = viewDate;
    }

    /**
     * Polls the time and notifies event handlers if events are starting.
     */
    public void pollTime() {
        Runnable task = () -> {
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
        };

        myThread = new Thread(task);
        myThread.start();
    }

    /**
     * Stops the time polling thread.
     */
    public void stopTime() {
        myThread.interrupt();
    }
}

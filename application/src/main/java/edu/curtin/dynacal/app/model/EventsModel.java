package edu.curtin.dynacal.app.model;

import edu.curtin.dynacal.api.IEvent;
import java.util.List;

/**
 * Model class for managing calendar events.
 */
public class EventsModel {
    // Instance field
    private List<IEvent> eventsList;

    /**
     * Constructor to initialize EventsModel with a list of events.
     *
     * @param eventsList The list of events to be managed by the model.
     */
    public EventsModel(List<IEvent> eventsList) {
        this.eventsList =  eventsList;
    }

    /**
     * Adds a new event to the list of events.
     *
     * @param event The event to be added.
     */
    public void addEvent(IEvent event) {
        eventsList.add(event);
    }

    /**
     * Gets the list of events managed by the model.
     *
     * @return The list of events.
     */
    public List<IEvent> getEventsList() {
        return eventsList;
    }
}

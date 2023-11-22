package edu.curtin.dynacal.api;

/**
 * Interface for handling events in a calendar system.
 */
public interface IEventHandler {

    /**
     * Called when an event has started.
     *
     * @param event The event that has started.
     */
    void eventStarted(IEvent event);
}

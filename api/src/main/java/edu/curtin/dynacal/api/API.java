package edu.curtin.dynacal.api;

/**
 * An interface representing the API for handling calendar-related operations.
 */
public interface API {

    /**
     * Register an event.
     *
     * @param event The event to be registered.
     */
    void registerEvent(IEvent event);

    /**
     * Register an event handler.
     *
     * @param eventHandler The event handler to be registered.
     */
    void registerEventHandler(IEventHandler eventHandler);
}

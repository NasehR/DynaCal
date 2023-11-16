package edu.curtin.dynacal.api;

public interface API {

    /*
    * Register an event
    * @param eventName the name of the event
    * @return void
     */
    void registerEvent(IEvent event);

    /*
     * Register an event handler
     * @param eventName the name of the event
     * @return void
     */
    void registerEventHandler(IEventHandler eventHandler);
}
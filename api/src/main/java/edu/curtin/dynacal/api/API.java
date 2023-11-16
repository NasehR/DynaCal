package edu.curtin.dynacal.api;

public interface API {

    /*
    * Register an event
    * @param eventName the name of the event
    * @return void
     */
    void registerEvent(IEvent event);
}
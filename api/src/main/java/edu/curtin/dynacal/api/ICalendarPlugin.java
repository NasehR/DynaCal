package edu.curtin.dynacal.api;

import java.util.Map;

/**
 * An interface representing a plugin for the calendar system.
 */
public interface ICalendarPlugin {

    /**
     * Start the calendar plugin.
     *
     * @param api         The API for calendar-related operations.
     * @param parameters  A map of parameters specific to the plugin.
     */
    void start(API api, Map<String, String> parameters);
}

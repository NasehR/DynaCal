package edu.curtin.dynacal.calplugins;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.ICalendarPlugin;
import javax.swing.JOptionPane;
import java.util.Map;

/**
 * The Notify class is a calendar plugin that displays a notification when a specific event starts.
 */
public class Notify implements ICalendarPlugin {

    /**
     * Starts the Notify plugin by registering an event handler with the provided API.
     *
     * @param api        The API for interacting with the calendar system.
     * @param parameters A map of parameters that can be used to configure the plugin.
     */
    @Override
    public void start(API api, Map<String, String> parameters) {
        // Extract the title parameter from the plugin configuration
        String text = parameters.get("title");

        // Register an event handler to listen for events with the specified title
        api.registerEventHandler((event) -> {
            // Check if the event name matches the specified title
            if (event.getName().equals(text)) {
                // Display a notification when the event starts
                JOptionPane.showMessageDialog(null,  text + " STARTED!!!!!");
            }
        });
    }
}

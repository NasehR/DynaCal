package edu.curtin.dynacal.app.controller;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.ICalendarPlugin;
import org.python.core.PyException;
import org.python.util.PythonInterpreter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Controller class for managing calendar plugins and running scripts.
 */
public class ExtraController {

    // Instance fields
    private List<ICalendarPlugin> calendarPluginList;
    private List<String> scriptsList;
    private API api;

    /**
     * Constructor to initialize ExtraController with API and script list.
     *
     * @param api         The API instance to interact with the calendar.
     * @param scriptsList List of Python scripts to be executed.
     */
    public ExtraController(API api, List<String> scriptsList) {
        calendarPluginList = new ArrayList<>();
        this.scriptsList = scriptsList;
        this.api = api;
    }

    /**
     * Initializes calendar plugins based on plugin information.
     *
     * @param plugInInfo Map containing plugin class names and their parameters.
     */
    public void initalizePlugins(Map<String, Map<String, String>> plugInInfo) {
        for (var plugInEntry : plugInInfo.entrySet()) {
            try {
                Class<?> classTemp = Class.forName(plugInEntry.getKey());

                if (ICalendarPlugin.class.isAssignableFrom(classTemp)) {
                    ICalendarPlugin plugin = (ICalendarPlugin) classTemp.getConstructor().newInstance();
                    calendarPluginList.add(plugin);

                    // Start the plugin with API and parameters
                    plugin.start(api, plugInEntry.getValue());
                }
            } catch (ClassNotFoundException | InvocationTargetException | InstantiationException |
                     IllegalAccessException | NoSuchMethodException exception) {
                System.out.println(exception.toString());
            }
        }
    }

    /**
     * Runs Python scripts using a PythonInterpreter.
     */
    public void runScripts() {
        for (String script : scriptsList) {
            try (PythonInterpreter interpreter = new PythonInterpreter()) {
                // Set the calendar API as a variable in the Python environment
                interpreter.set("calendar", this.api);

                // Execute the Python script
                interpreter.exec(script);
            } catch (PyException exception) {
                System.out.println(exception.toString());
            }
        }
    }
}

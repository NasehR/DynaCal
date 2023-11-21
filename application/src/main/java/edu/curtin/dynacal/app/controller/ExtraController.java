package edu.curtin.dynacal.app.controller;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.ICalendarPlugin;
import org.python.core.PyException;
import org.python.util.PythonInterpreter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtraController {

    private List<ICalendarPlugin> calendarPluginList;
    private List<String> scriptsList;
    private API api;

    public ExtraController(API api, List<String> scriptsList) {
        calendarPluginList = new ArrayList<>();
        this.scriptsList = scriptsList;
        this.api = api;
    }

    public void initalisePlugins(Map<String, Map<String, String>> plugInInfo) {
        for (var plugInEntry : plugInInfo.entrySet()) {
            try {
                Class<?> classTemp = Class.forName(plugInEntry.getKey());

                if (ICalendarPlugin.class.isAssignableFrom(classTemp)) {
                    ICalendarPlugin plugin = (ICalendarPlugin) classTemp.getConstructor().newInstance();
                    calendarPluginList.add(plugin);

                    plugin.start(api, plugInEntry.getValue());
                }
            }
            catch (ClassNotFoundException | InvocationTargetException | InstantiationException |
                     IllegalAccessException | NoSuchMethodException exception) {
                System.out.println(exception.toString());
            }
        }
    }

    public void runScripts() {
        for (String script: scriptsList) {
            try (PythonInterpreter interpreter = new PythonInterpreter()) {
                interpreter.set("calendar", this.api);

                interpreter.exec(script);
            }
            catch (PyException exception) {
                System.out.println(exception.toString());
            }
        }
    }
}

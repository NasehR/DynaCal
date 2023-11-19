package edu.curtin.dynacal.calplugins;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.ICalendarPlugin;
import edu.curtin.dynacal.api.IEventHandler;

import javax.swing.JOptionPane;
import java.util.Map;

public class Notify implements ICalendarPlugin {
    @Override
    public void start(API api, Map<String, String> parameters) {
        System.out.println("Plugin Started");

        String text = parameters.get("title");
        api.registerEventHandler((event) -> {
            if (event.getName().equals(text)) {
                JOptionPane.showMessageDialog(null,  text + " STARTED!!!!!");
            }
        });
    }
}

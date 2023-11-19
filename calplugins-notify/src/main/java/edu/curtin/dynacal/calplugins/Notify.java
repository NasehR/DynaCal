package edu.curtin.dynacal.calplugins;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.ICalendarPlugin;
import edu.curtin.dynacal.api.IEvent;

import javax.swing.*;
import java.util.Map;

public class Notify implements ICalendarPlugin {

    private API api;

    @Override
    public void start(API api, Map<String, String> parameters) {
        System.out.println("Plugin Started");
    }
}

package edu.curtin.dynacal.calplugins;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.ICalendarPlugin;
import edu.curtin.dynacal.api.IEvent;

import java.util.Map;

public class Repeat implements ICalendarPlugin {

    private API api;

    @Override
    public void start(API api, Map<String, String> parameters) {

    }

    @Override
    public void onEvent(IEvent event) {

    }
}

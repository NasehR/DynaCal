package edu.curtin.dynacal.calplugins;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.ICalendarPlugin;
import edu.curtin.dynacal.api.IEvent;

public class Notify implements ICalendarPlugin {

    private API api;

    @Override
    public void start(API api) {
        this.api = api;
    }

    @Override
    public void onEvent(IEvent event) {

    }
}

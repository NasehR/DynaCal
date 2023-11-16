package edu.curtin.dynacal.calplugins;

import edu.curtin.dynacal.api.API;
import edu.curtin.dynacal.api.ICalendarPlugin;

public class Repeat implements ICalendarPlugin {

    private API api;

    @Override
    public void start(API api) {
        this.api = api;
    }
}

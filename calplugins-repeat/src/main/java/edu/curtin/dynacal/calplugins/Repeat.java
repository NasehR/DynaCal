package edu.curtin.dynacal.calplugins;

public class Repeat implements ICalendarPlugin {

    private API api;

    @Override
    public void start(API api) {
        this.api = api;
    }
}

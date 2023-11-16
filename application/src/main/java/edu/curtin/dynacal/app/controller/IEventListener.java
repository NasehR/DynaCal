package edu.curtin.dynacal.app.controller;

import edu.curtin.dynacal.api.IEvent;

public interface IEventListener {
    void onEvent(IEvent event);
}

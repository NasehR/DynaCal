package edu.curtin.dynacal.app;

import edu.curtin.dynacal.api.IEvent;
import edu.curtin.dynacal.app.controller.CalendarController;
import edu.curtin.dynacal.app.controller.ExtraController;
import edu.curtin.dynacal.app.model.EventsModel;
import edu.curtin.dynacal.app.view.TerminalView;
import edu.curtin.terminalgrid.TerminalGrid;
import edu.curtin.dynacal.dsl.CalendarParser;
import edu.curtin.dynacal.dsl.ParseException;
import org.w3c.dom.events.Event;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class Main {
    // TODO:
        // displaying the calendar (Need I18N)      (EASY ())       (NOT DONE)
        // viewing the calendar (movement wise)     (DIFFICULT??)   (NOT DONE)
        // Internationalisation (Spanish ...)       (MEDIUM ())     (NOT DONE)
        // Documentation                            (EASY (0))      (NOT DONE)

    // MODEL (M)
        // - All the events                                         (DONE)
    // VIEW (V)
        // - Responsible for printing text on the terminal          (DONE)
        // - User interactions
    // CONTROLLER (C)
        // - Handle all the extras (running plugins and scripts)    (DONE)
        // - calendar navigation (moving)

    // V -> C -> V.
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new ArrayIndexOutOfBoundsException("Incorrect number of arguments provided. The application requires one argument however, " + args.length + "argument/s were provided.");
        }

        System.out.println("Welcome to DYNACAL");

        // Initialising
        CalendarParser p;
        var terminalGrid = TerminalGrid.create();
        // TODO: Changed later for I18N
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        List<IEvent> eventList = List.of();
        Map<String, Map<String, String>> plugInInfo = Map.of();
        List<String> scripts = List.of();
        CalendarController calendarController;
        ExtraController extraController;
        EventsModel eventsModel;
        TerminalView terminalView;

        try {
            p = CalendarParser.parse(args[0]);
            eventList = p.getEventList();
            plugInInfo = p.getPlugInInfo();
            scripts = p.getScripts();

            /*
            for ( IEvent event: eventList ) {
                System.out.println(event.getName());
                System.out.println(event.getStartDate());
            }
             */
            /*
            for (var keyValuePair: plugInInfo.entrySet()) {
                System.out.println(keyValuePair.getKey() + ":");
                for (var keyValuePair1: keyValuePair.getValue().entrySet()) {
                    System.out.println("\t" + keyValuePair1.getKey() + ": " + keyValuePair1.getValue());
                }
            }
             */
            /*
            for ( String script: scripts ) {
                System.out.println(script);
            }
             */

        }
        catch (ParseException exception) {
            System.out.println(exception.toString());
        }
        catch (IOException exception) {
            System.out.println(exception.toString());
        }

        eventsModel = new EventsModel(eventList);
        calendarController = new CalendarController(eventsModel);
        extraController = new ExtraController(calendarController, scripts);

        extraController.initalisePlugins(plugInInfo);
        extraController.runScripts();

        terminalView = new TerminalView(terminalGrid, eventList, dateFormatter, timeFormatter);
        terminalView.print();
    }
}
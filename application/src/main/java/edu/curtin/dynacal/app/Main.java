package edu.curtin.dynacal.app;

import edu.curtin.dynacal.api.IEvent;
import edu.curtin.dynacal.app.controller.CalendarController;
import edu.curtin.dynacal.app.controller.ExtraController;
import edu.curtin.dynacal.app.model.EventsModel;
import edu.curtin.dynacal.app.view.TerminalView;
import edu.curtin.dynacal.app.view.UIView;
import edu.curtin.terminalgrid.TerminalGrid;
import edu.curtin.dynacal.dsl.CalendarParser;
import edu.curtin.dynacal.dsl.ParseException;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class Main {
    // TODO:
        // displaying the calendar (Need I18N)      (EASY ())       (NOT DONE)
        // Internationalisation (Spanish ...)       (MEDIUM ())     (NOT DONE)
        // Documentation                            (EASY (0))      (NOT DONE)

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new ArrayIndexOutOfBoundsException("Incorrect number of arguments provided. The application requires one argument however, " + args.length + "argument/s were provided.");
        }

        // Initialising
        CalendarParser p;
        var terminalGrid = TerminalGrid.create();
        // TODO: Changed later for I18N
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        List<IEvent> eventList = List.of();
        Map<String, Map<String, String>> plugInInfo = Map.of();
        List<String> scripts = List.of();
        CalendarController calendarController;
        ExtraController extraController;
        EventsModel eventsModel;
        TerminalView terminalView;
        UIView uiNavigation;

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

            for (var keyValuePair: plugInInfo.entrySet()) {
                System.out.println(keyValuePair.getKey() + ":");
                for (var keyValuePair1: keyValuePair.getValue().entrySet()) {
                    System.out.println("\t" + keyValuePair1.getKey() + ": " + keyValuePair1.getValue());
                }
            }

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
        terminalView = new TerminalView(terminalGrid, calendarController, dateFormatter, timeFormatter);
        uiNavigation = new UIView(calendarController);
        extraController.initalisePlugins(plugInInfo);
        extraController.runScripts();

        calendarController.pollTime();
        for (int ii = 0; ii < 10; ii++){
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Welcome to DYNACAL");
            terminalView.print();
            uiNavigation.move();
        }
    }
}
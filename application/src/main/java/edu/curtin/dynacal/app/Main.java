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

import java.util.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Locale> locales = new HashMap<>();
        locales.put(0, new Locale("en", "AU"));
        locales.put(1, new Locale("es", "ES"));
        locales.put(2, new Locale("en", "US"));

        int input = (args.length == 1) ? 0 : Integer.parseInt(args[1]);
        Locale locale = locales.get(input);

        ResourceBundle resourceBundle = ResourceBundle.getBundle("bundle", locale);

        if (args.length > 2) {
            throw new ArrayIndexOutOfBoundsException(resourceBundle.getString("invalid_parameters_1") + args.length + resourceBundle.getString("invalid_parameters_2"));
        }

        // Initialising
        CalendarParser p;
        var terminalGrid = TerminalGrid.create();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(resourceBundle.getString("date_format"));
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(resourceBundle.getString("time_format"));
        List<IEvent> eventList = List.of();
        Map<String, Map<String, String>> plugInInfo = Map.of();
        List<String> scripts = List.of();
        CalendarController calendarController;
        ExtraController extraController;
        EventsModel eventsModel;
        TerminalView terminalView;
        UIView uiNavigation;

        try {
            String encoding = "UTF-8";
            if (args[0].contains(".utf16.")) {
                encoding = "UTF-16";
            }
            else if (args[0].contains(".utf32.")) {
                encoding = "UTF-32";
            }

            p = CalendarParser.parse(args[0], encoding);
            eventList = p.getEventList();
            plugInInfo = p.getPlugInInfo();
            scripts = p.getScripts();
        }
        catch (ParseException parseException) {
            System.out.println(parseException.toString());
        }
        catch (IOException ioException) {
            System.out.println(ioException.toString());
        }

        eventsModel = new EventsModel(eventList);
        calendarController = new CalendarController(eventsModel);
        extraController = new ExtraController(calendarController, scripts);
        terminalView = new TerminalView(terminalGrid, calendarController, dateFormatter, timeFormatter);
        uiNavigation = new UIView(calendarController, terminalView, resourceBundle);
        extraController.initalisePlugins(plugInInfo);
        extraController.runScripts();

        calendarController.pollTime();
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(resourceBundle.getString("welcome"));
        uiNavigation.move();
    }
}
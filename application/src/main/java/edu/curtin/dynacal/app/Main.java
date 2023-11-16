package edu.curtin.dynacal.app;

import edu.curtin.dynacal.api.IEvent;
import edu.curtin.dynacal.app.view.TerminalView;
import edu.curtin.terminalgrid.TerminalGrid;
import edu.curtin.dynacal.dsl.CalendarParser;
import edu.curtin.dynacal.dsl.ParseException;
import org.w3c.dom.events.Event;

import java.io.IOException;
import java.lang.reflect.Array;
import java.security.cert.CertificateNotYetValidException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    // TODO:
    // - handling scripts                                           (MEDIUM (2)) REFLECTIONS
    // - handling plugins                                           (EASY (3))
    // - handling notifications                                     (EASY (1))
    // - displaying the calendar                                    (EASY ())
        // DONE
    // - viewing the calendar (movement wise)                       (DIFFICULT??)
    // - Internationalisation (Spanish and maybe others if time)    (MEDIUM ())
    // - Documentation                                              (EASY (0))

    // MODEL (M)
        // - All the events
        // -
    // VIEW (V)
        // - Responsible for printing text on the terminal          (DONE)
        // - User interactions
    // CONTROLLER (C)
        // - Handle all the extras (running plugins and scripts when called)
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
        Map<String, Map<String, String>> plugInInfo;
        List<String> scripts;

        try {
            p = CalendarParser.parse(args[0]);
            eventList = p.getEventList();
            plugInInfo = p.getPlugInInfo();
            scripts = p.getScripts();

//            for ( IEvent event: eventList ) {
//                System.out.println(event.getName());
//                System.out.println(event.getStartDate());
//            }
//
//            for (var keyValuePair: plugInInfo.entrySet()) {
//                System.out.println(keyValuePair.getKey() + ":");
//                for (var keyValuePair1: keyValuePair.getValue().entrySet()) {
//                    System.out.println("\t" + keyValuePair1.getKey() + ": " + keyValuePair1.getValue());
//                }
//            }
//
//            for ( String script: scripts ) {
//                System.out.println(script);
//            }

        }
        catch (ParseException exception) {
            System.out.println(exception.toString());
        }
        catch (IOException exception) {
            System.out.println(exception.toString());
        }

        TerminalView terminalView = new TerminalView(terminalGrid, eventList, dateFormatter, timeFormatter);
        terminalView.print();
    }
}
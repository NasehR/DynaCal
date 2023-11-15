package edu.curtin.dynacal.app;

import edu.curtin.dynacal.api.IEvent;
import edu.curtin.terminalgrid.TerminalGrid;
import edu.curtin.dynacal.dsl.CalendarParser;
import edu.curtin.dynacal.dsl.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    // TODO:
    // - handling scripts                                           (MEDIUM (2)) REFLECTIONS
    // - handling plugins                                           (EASY (3))
    // - handling notifications                                     (EASY (1))
    // - displaying the calendar                                    (EASY ())
    // - viewing the calendar (movement wise)                       (DIFFICULT??)
    // - Internationalisation (Spanish and maybe others if time)    (MEDIUM ())
    // - Documentation                                              (EASY (0))

    // MODEL (M)
        // - All the events
        // -
    // VIEW (V)
        // - Responsible for printing text on the terminal
        // - User interactions
    // CONTROLLER (C)
        // - Handle all the extras (running plugins and scripts when called)
        // - calendar navigation (moving)

    // V -> C -> V.
    public static void main(String[] args) {
        System.out.println(args.length);

        
        if (args.length != 1) {
            System.out.println("Incorrect number of arguments provided. The application requires one argument however, " + args.length + "argument/s were provided.");
        }

        System.out.println("Welcome to DYNACAL");

        CalendarParser p;

        try {
            p = CalendarParser.parse(args[0]);
            List<IEvent> eventList = p.getEventList();
            Map<String, Map<String, String>> plugInInfo = p.getPlugInInfo();
            List<String> scripts = p.getScripts();

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

        }
        catch (ParseException exception) {
            System.out.println(exception.toString());
        }
        catch (IOException exception) {
            System.out.println(exception.toString());
        }


        // Demonstration data
        String[][] messages = {{"one two three",     "four five six",             "seven eight nine"},
                {"ten eleven twelve", "thirteen fourteen fifteen", "sixteen seventeen eighteen"}};

        String[] rowHeadings = {"row 1", "row 2"};
        String[] colHeadings = {"column A", "column B", "column C"};


        // Initialising
        var terminalGrid = TerminalGrid.create();

        // With custom box-drawing characters (if you must!)
        terminalGrid.setBoxChars(new TerminalGrid.BoxChars(
                "\u2502 ", " \u250a ", " \u2502",
                "\u2500", "\u254c", "\u2500",
                "\u256d\u2500", "\u2500\u256e", "\u2570\u2500", "\u2500\u256f",
                "\u2500\u252c\u2500", "\u2500\u2534\u2500", "\u251c\u254c", "\u254c\u2524", "\u254c\u253c\u254c"));
        terminalGrid.print(messages, rowHeadings, colHeadings);

    }
}
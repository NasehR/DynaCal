package edu.curtin.dynacal.app;

import edu.curtin.dynacal.api.IEvent;
import edu.curtin.terminalgrid.TerminalGrid;
import edu.curtin.dynacal.dsl.CalendarParser;
import edu.curtin.dynacal.dsl.ParseException;
import java.io.IOException;
import java.lang.reflect.Array;
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
        if (args.length != 1) {
//            System.out.println("Incorrect number of arguments provided. The application requires one argument however, " + args.length + "argument/s were provided.");
            throw new ArrayIndexOutOfBoundsException("Incorrect number of arguments provided. The application requires one argument however, " + args.length + "argument/s were provided.");
        }

        System.out.println("Welcome to DYNACAL");

        // Initialising
        CalendarParser p;
        var terminalGrid = TerminalGrid.create();
        // TODO: Changed later for I18N
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM");

        try {
            p = CalendarParser.parse(args[0]);
            List<IEvent> eventList = p.getEventList();
            Map<String, Map<String, String>> plugInInfo = p.getPlugInInfo();
            List<String> scripts = p.getScripts();

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


        // Demonstration data
        String[][] events =  new String[25][7];
        String[] times = new String[25];
        String[] days = new String[7];

        // events
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 7; j++) {
                events[i][j] = "";
            }
        }

        //time
        for (int i = 0; i < 25; i++) {
            String time = "";
            if (i == 0) {
                time = "All-Day";
            }
            else if (i-1 < 10){
                time = "0" + (i-1) + "00";
            }
            else {
                time = (i-1) + "00";
            }
            times[i] = time;
        }

        //day
        for (int i = 0; i < 7; i++) {
            days[i] = LocalDate.now()
                    .plusDays(i)
                    .format(dateFormatter);
        }

        // With custom box-drawing characters (if you must!)
        terminalGrid.setBoxChars(new TerminalGrid.BoxChars(
                "\u2502 ", " \u250a ", " \u2502",
                "\u2500", "\u254c", "\u2500",
                "\u256d\u2500", "\u2500\u256e", "\u2570\u2500", "\u2500\u256f",
                "\u2500\u252c\u2500", "\u2500\u2534\u2500", "\u251c\u254c", "\u254c\u2524", "\u254c\u253c\u254c"));
        terminalGrid.print(events, times, days);
    }
}
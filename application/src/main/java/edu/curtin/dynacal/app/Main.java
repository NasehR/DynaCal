package edu.curtin.dynacal.app;

import edu.curtin.dynacal.api.IEvent;
import edu.curtin.dynacal.dsl.CalendarParser;
import edu.curtin.dynacal.dsl.ParseException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            //
        }

        System.out.println("Welcome to DYNACAL");

        CalendarParser p;

        try {
            p = CalendarParser.parse(args[0]);
            List<IEvent> eventList = p.getEventList();
            Map<String, Map<String, String>> plugInInfo = p.getPlugInInfo();

            for ( IEvent event: eventList ) {
                System.out.println(event.getName());
                System.out.println(event.getStartDate());
            }

            System.out.println(plugInInfo.isEmpty());

            for (var keyValuePair: plugInInfo.entrySet()) {
                System.out.println(keyValuePair.getKey() + ":");
                for (var keyValuePair1: keyValuePair.getValue().entrySet()) {
                    System.out.println("\t" + keyValuePair1.getKey() + ": " + keyValuePair1.getValue());
                }
            }

        }
        catch (ParseException exception) {
            System.out.println(exception.toString());
        }
        catch (IOException exception) {
            System.out.println(exception.toString());
        }

    /*
        // Demonstration data
        String[][] messages = {{"one two three",     "four five six",             "seven eight nine"},
                {"ten eleven twelve", "thirteen fourteen fifteen", "sixteen seventeen eighteen"}};

        String[] rowHeadings = {"row 1", "row 2"};
        String[] colHeadings = {"column A", "column B", "column C"};


        // Initialising
        var terminalGrid = TerminalGrid.create();


        // Without headings
        terminalGrid.print(messages);
        System.out.println();


        // With headings
        terminalGrid.print(messages, rowHeadings, colHeadings);
        System.out.println();


        // Using nested lists rather than arrays
        var listMessages = new ArrayList<List<String>>();
        var row1 = new ArrayList<String>();
        var row2 = new ArrayList<String>();
        row1.add("one");
        row1.add("two");
        row2.add("three");
        row2.add("four");
        listMessages.add(row1);
        listMessages.add(row2);
        terminalGrid.print(listMessages, List.of("row 1", "row 2"), List.of("col A", "col B"));
        System.out.println();


        // With limited space
        terminalGrid.setTerminalWidth(42);
        terminalGrid.print(messages, rowHeadings, colHeadings);
        System.out.println();
        terminalGrid.setTerminalWidth(120);


        // Specifying UTF-8 character encoding explicitly (may help make box-drawing characters work)
        terminalGrid.setCharset(java.nio.charset.Charset.forName("UTF-8"));
        terminalGrid.print(messages, rowHeadings, colHeadings);
        System.out.println();


        // With plain ASCII characters (fallback if the real box-drawing characters just don't display properly)
        terminalGrid.setBoxChars(TerminalGrid.ASCII_BOX_CHARS);
        terminalGrid.print(messages, rowHeadings, colHeadings);
        System.out.println();


        // With custom box-drawing characters (if you must!)
        terminalGrid.setBoxChars(new TerminalGrid.BoxChars(
                "\u2502 ", " \u250a ", " \u2502",
                "\u2500", "\u254c", "\u2500",
                "\u256d\u2500", "\u2500\u256e", "\u2570\u2500", "\u2500\u256f",
                "\u2500\u252c\u2500", "\u2500\u2534\u2500", "\u251c\u254c", "\u254c\u2524", "\u254c\u253c\u254c"));
        terminalGrid.print(messages, rowHeadings, colHeadings);
    */
    }
}
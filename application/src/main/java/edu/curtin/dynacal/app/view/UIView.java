package edu.curtin.dynacal.app.view;

import edu.curtin.dynacal.api.IEvent;
import edu.curtin.dynacal.app.controller.CalendarController;

import javax.swing.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UIView {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    private final Map<String, IDateStrategy> navigation;
    private CalendarController calendarController;
    private TerminalView terminalView;

    public UIView(CalendarController calendarController, TerminalView terminalView) {
        this.calendarController = calendarController;
        this.terminalView = terminalView;

        navigation = new HashMap<>();
        navigation.put("+d", new AddDayStrategy());
        navigation.put("+w", new AddWeekStrategy());
        navigation.put("+m", new AddMonthStrategy());
        navigation.put("+y", new AddYearStrategy());
        navigation.put("-d", new TakeDayStrategy());
        navigation.put("-w", new TakeWeekStrategy());
        navigation.put("-m", new TakeMonthStrategy());
        navigation.put("-y", new TakeYearStrategy());
        navigation.put("t", new TodayStrategy());
    }

    public void move(){
        try (Scanner scanner = new Scanner(System.in)) {;
            String input;
            do {
                terminalView.print();
                input = scanner.nextLine();

                System.out.print("\033[H\033[2J");
                System.out.flush();

                if (navigation.containsKey(input)) {
                    LocalDate currentDate = calendarController.getViewDate();
                    LocalDate newDate = navigation.get(input).moveToNewDate(currentDate);
                    calendarController.setViewDate(newDate);
                }
                else if (input.equals("quit")) {
                    System.out.println("Exiting the Program.");
                    calendarController.stopTime();
                }
                else if (input.equals("search")) {
                    search(scanner);
                }
                else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(ANSI_RED + "Not a valid input.");
                    System.out.println("The valid commands are:");
                    for (String key : navigation.keySet()) {
                        System.out.println("\t" + key + "\t:\t" + navigation.get(key).toString());
                    }
                    System.out.println("\tsearch\t:\tTo search for an event.");
                    System.out.println("\tquit\t:\tTo exit the program.\n\n" + ANSI_RESET);
                }
            } while(!(input.equals("quit")));
        }
    }

    private void search(Scanner scanner) {
        String event = scanner.nextLine();
        List<IEvent> events = calendarController.getEventsList();
        StringBuilder stringBuilder = new StringBuilder();

        if (events.isEmpty()) {
            stringBuilder.append("No events to search.");
        }
        else {
            boolean found = false;
            for (IEvent e : events) {
                if (e.getName().equals(event) && e.getStartDate().isAfter(LocalDate.now().minusDays(1))) {
                    stringBuilder.append("Title:\t").append(e.getName()).append("\nStart Date:\t").append(e.getStartDate());

                    if (e.getStartTime().isPresent() && e.getDuration().isPresent()) {
                        stringBuilder.append("\nStart Time:\t").append(e.getStartTime().get()).append("\nDuration:\t").append(e.getDuration().get()).append(" minutes");
                        found = true;
                    }
                }
            }
            if (!found) {
                stringBuilder.append("No events found matching the search: ").append(event);
            }
        }

        JOptionPane.showMessageDialog(null,  stringBuilder.toString());
    }
}

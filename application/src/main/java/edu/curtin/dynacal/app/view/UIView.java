package edu.curtin.dynacal.app.view;

import edu.curtin.dynacal.api.IEvent;
import edu.curtin.dynacal.app.controller.CalendarController;

import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

public class UIView {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    private final Map<String, IDateStrategy> navigation;
    private CalendarController calendarController;
    private TerminalView terminalView;
    private ResourceBundle resourceBundle;

    public UIView(CalendarController calendarController, TerminalView terminalView, ResourceBundle resourceBundle) {
        this.calendarController = calendarController;
        this.terminalView = terminalView;
        this.resourceBundle = resourceBundle;

        navigation = new HashMap<>();
        navigation.put("+d", new AddDayStrategy(this.resourceBundle));
        navigation.put("+w", new AddWeekStrategy(this.resourceBundle));
        navigation.put("+m", new AddMonthStrategy(this.resourceBundle));
        navigation.put("+y", new AddYearStrategy(this.resourceBundle));
        navigation.put("-d", new TakeDayStrategy(this.resourceBundle));
        navigation.put("-w", new TakeWeekStrategy(this.resourceBundle));
        navigation.put("-m", new TakeMonthStrategy(this.resourceBundle));
        navigation.put("-y", new TakeYearStrategy(this.resourceBundle));
        navigation.put("t", new TodayStrategy(this.resourceBundle));
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
                    System.out.println(resourceBundle.getString("Exiting_the_Program"));
                    calendarController.stopTime();
                }
                else if (input.equals("search")) {
                    search(scanner);
                }
                else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(ANSI_RED + resourceBundle.getString("Not_a_valid_input"));
                    System.out.println(resourceBundle.getString("The_valid_commands_are"));
                    for (String key : navigation.keySet()) {
                        System.out.println("\t" + key + "\t:\t" + navigation.get(key).toString());
                    }
                    System.out.println("\tsearch\t:\t" + resourceBundle.getString("To_search_for_an_event"));
                    System.out.println("\tquit\t:\t" + resourceBundle.getString("To_exit_the_program") + "\n\n" + ANSI_RESET);
                }
            } while(!(input.equals("quit")));
        }
    }

    private void search(Scanner scanner) {
        String event = scanner.nextLine();
        List<IEvent> events = calendarController.getEventsList();
        StringBuilder stringBuilder = new StringBuilder();

        if (events.isEmpty()) {
            stringBuilder.append(resourceBundle.getString("No_events_to_search"));
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
                stringBuilder.append(resourceBundle.getString("No_events_found_matching_the_search")).append(event);
            }
        }

        JOptionPane.showMessageDialog(null,  stringBuilder.toString());
    }
}

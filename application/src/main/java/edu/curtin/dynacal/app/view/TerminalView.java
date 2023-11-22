package edu.curtin.dynacal.app.view;

import edu.curtin.dynacal.api.IEvent;
import edu.curtin.dynacal.app.controller.CalendarController;
import edu.curtin.terminalgrid.TerminalGrid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The TerminalView class represents the text-based view of the calendar in a terminal.
 * It uses a TerminalGrid to display events for a given week.
 */
public class TerminalView {

    private TerminalGrid calendarGrid;
    /* default */ DateTimeFormatter dateFormatter;
    /* default */ DateTimeFormatter timeFormatter;
    /* default */ CalendarController calendarController;

    /**
     * Constructs a TerminalView with the specified parameters.
     *
     * @param calendarGrid       The TerminalGrid used for displaying the calendar.
     * @param calendarController The CalendarController providing data for the view.
     * @param dateFormatter      The formatter for displaying dates.
     * @param timeFormatter      The formatter for displaying times.
     */
    public TerminalView(TerminalGrid calendarGrid, CalendarController calendarController, DateTimeFormatter dateFormatter, DateTimeFormatter timeFormatter) {
        this.calendarGrid = calendarGrid;
        this.calendarController = calendarController;
        this.dateFormatter = dateFormatter;
        this.timeFormatter = timeFormatter;
    }

    /**
     * Prints the current week's calendar events in a text-based format.
     */
    public void print() {
        // Demonstration data
        String[][] events = new String[25][7];
        String[] times = new String[25];
        String[] days = new String[7];

        // Initialize events array
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 7; j++) {
                events[i][j] = "";
            }
        }

        // Initialize times array
        for (int i = 0; i < 25; i++) {
            String time;
            if (i == 0) {
                time = "All-Day";
            } else if (i - 1 < 10) {
                time = "0" + (i - 1) + "00";
            } else {
                time = (i - 1) + "00";
            }
            times[i] = time;
        }

        // Initialize days array
        for (int i = 0; i < 7; i++) {
            days[i] = calendarController.getViewDate()
                    .plusDays(i)
                    .format(dateFormatter);
        }

        // Populate events array with actual events
        for (IEvent event : calendarController.getEventsList()) {
            LocalDate startDate = event.getStartDate();
            LocalDate startWeekDate = calendarController.getViewDate();
            LocalDate endWeekDate = calendarController.getViewDate().plusDays(6);
            StringBuilder stringBuilder = new StringBuilder();

            // Check if the event falls within the current week
            if (startDate.isAfter(startWeekDate.minusDays(1)) && startDate.isBefore(endWeekDate.plusDays(1))) {
                stringBuilder.append(event.getName());
                stringBuilder.append("\n");

                int dayIndex = startWeekDate.until(startDate).getDays();
                int timeIndex = 0;

                // Display start time if present
                if (event.getStartTime().isPresent()) {
                    timeIndex = event.getStartTime().get().getHour() + 1;

                    stringBuilder.append(event.getStartTime().get().format(timeFormatter));
                    stringBuilder.append("\n");
                }

                // Display duration if present
                if (event.getDuration().isPresent()) {
                    stringBuilder.append(event.getDuration().get());
                    stringBuilder.append("\n");
                }

                // Update the events array
                events[timeIndex][dayIndex] = events[timeIndex][dayIndex] + stringBuilder;
            }
        }

        // Set custom box-drawing characters
        calendarGrid.setBoxChars(TerminalGrid.ASCII_BOX_CHARS);

        // Print the calendar view
        calendarGrid.print(events, times, days);
    }
}

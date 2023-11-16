package edu.curtin.dynacal.app.view;

import edu.curtin.dynacal.api.IEvent;
import edu.curtin.terminalgrid.TerminalGrid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TerminalView {

    private TerminalGrid calendarGrid;
    private List<IEvent> eventList;
    DateTimeFormatter dateFormatter;

    public TerminalView(TerminalGrid calendarGrid, List<IEvent> eventList, DateTimeFormatter dateFormatter) {
        this.calendarGrid = calendarGrid;
        this.eventList = eventList;
        this.dateFormatter = dateFormatter;

    }

    public void print() {
        // Demonstration data
        String[][] events = new String[25][7];
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
            } else if (i - 1 < 10) {
                time = "0" + (i - 1) + "00";
            } else {
                time = (i - 1) + "00";
            }
            times[i] = time;
        }

        //day
        for (int i = 0; i < 7; i++) {
            days[i] = LocalDate.now()
                    .plusDays(i)
                    .format(dateFormatter);
        }

        for ( IEvent event : eventList) {
            LocalDate startDate = event.getStartDate();
            LocalDate startWeekDate = LocalDate.now();
            LocalDate endWeekDate = LocalDate.now().plusDays(6);

            if (startDate.isAfter(startWeekDate.minusDays(1)) && startDate.isBefore(endWeekDate.plusDays(1))) {
                System.out.println("Start Date:\t" + event.getStartDate());

                int dayIndex = startWeekDate.until(startDate).getDays();
                int timeIndex = 0;

                if (event.getStartTime().isPresent()) {
                    timeIndex = event
                            .getStartTime()
                            .get()
                            .getHour() + 1;
                }

                events[timeIndex][dayIndex] = events[timeIndex][dayIndex] + event.getName() + "\n";
            }
        }

        // With custom box-drawing characters (if you must!)
        calendarGrid.setBoxChars(new TerminalGrid.BoxChars(
                "\u2502 ", " \u250a ", " \u2502",
                "\u2500", "\u254c", "\u2500",
                "\u256d\u2500", "\u2500\u256e", "\u2570\u2500", "\u2500\u256f",
                "\u2500\u252c\u2500", "\u2500\u2534\u2500", "\u251c\u254c", "\u254c\u2524", "\u254c\u253c\u254c"));
        calendarGrid.print(events, times, days);
    }
}

package edu.curtin.dynacal.app.view;

import edu.curtin.dynacal.app.controller.CalendarController;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UIView {
    private final Map<String, IDateStrategy> navigation;
    private CalendarController calendarController;
    public UIView(CalendarController calendarController) {
        this.calendarController = calendarController;

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
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();

            if (navigation.containsKey(input)) {
                LocalDate currentDate = calendarController.getViewDate();
                LocalDate newDate = navigation.get(input).moveToNewDate(currentDate);
                calendarController.setViewDate(newDate);
            }
            else if (input.equals("quit")) {
                System.out.println("Exit Program.");
                calendarController.stopTime();
            }
            else {
                System.out.println("Not a valid input.");
            }
        }
    }
}

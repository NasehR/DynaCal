package edu.curtin.dynacal.calplugins;

import edu.curtin.dynacal.api.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Repeat implements ICalendarPlugin {
    @Override
    public void start(API api, Map<String, String> parameters) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        for (var p: parameters.entrySet()) {
            System.out.println(p.getKey() + ": " + p.getValue());
        }
        IEvent newEvent;
        String title = parameters.get("title");
        LocalDate startDate = LocalDate.parse(parameters.get("startDate"), dateFormatter);
        int dayDuration = Integer.parseInt(parameters.get("repeat"));
        int counter = 0;


        if (parameters.containsKey("startTime") && parameters.containsKey("duration")) {
            LocalTime startTime = LocalTime.parse(parameters.get("startTime"), timeFormatter);
            int duration = Integer.parseInt(parameters.get("duration"));

            for (LocalDate currentDate = startDate; currentDate.isBefore(startDate.plusYears(1)); currentDate = currentDate.plusDays(dayDuration)) {
                String t = title + " " + counter;
                newEvent = new TODCalendarEvent(t, currentDate, startTime, duration);
                api.registerEvent(newEvent);
                counter++;
            }
        }
        else {
            for (LocalDate currentDate = startDate; currentDate.isBefore(startDate.plusYears(1)); currentDate = currentDate.plusDays(dayDuration)) {
                String t = title + " " + counter;
                newEvent = new AllDayCalendarEvent(t, currentDate);
                api.registerEvent(newEvent);
                counter++;
            }
        }
    }
}

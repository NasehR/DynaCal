package edu.curtin.dynacal.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public interface IEvent {
    String getName();
    LocalDate getStartDate();
    Optional<LocalTime> getStartTime();
    Optional<Integer> getDuration();

}

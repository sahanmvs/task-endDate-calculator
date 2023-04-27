package com.mvs.taskmanagementapp.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

@Service
public class TaskCompletionDateServiceImpl implements TaskCompletionDateService{

    private Set<LocalDate> holidays = Set.of(
            // List of Holidays, can integrate db :)
            LocalDate.of(2023, Month.JANUARY, 15),
            LocalDate.of(2023,Month.FEBRUARY,04),
            LocalDate.of(2023,Month.FEBRUARY,05),
            LocalDate.of(2023,Month.FEBRUARY,18),
            LocalDate.of(2023,Month.APRIL,05),
            LocalDate.of(2023,Month.APRIL,07),
            LocalDate.of(2023,Month.APRIL,13),
            LocalDate.of(2023,Month.APRIL,14),
            LocalDate.of(2023,Month.APRIL,22),
            LocalDate.of(2023, Month.MAY, 01),
            LocalDate.of(2023,Month.MAY,05),
            LocalDate.of(2023,Month.MAY,06),
            LocalDate.of(2023,Month.JUNE,03),
            LocalDate.of(2023,Month.JULY,03),
            LocalDate.of(2023,Month.AUGUST,30),
            LocalDate.of(2023,Month.SEPTEMBER,26),
            LocalDate.of(2023,Month.SEPTEMBER,29),
            LocalDate.of(2023,Month.OCTOBER,28),
            LocalDate.of(2023,Month.NOVEMBER,12),
            LocalDate.of(2023,Month.NOVEMBER,26),
            LocalDate.of(2023,Month.DECEMBER,25),
            LocalDate.of(2023,Month.DECEMBER,26)

    );
    @Override
    public LocalDate calTaskCompletionDate(LocalDate startDate, int numberOfDays) {
        int businessDays = 0;
        LocalDate date = startDate;

        while (businessDays < numberOfDays) {
            if(isWeekDay(date) && !isHoliday(date)) {
                businessDays++;
            }
            date = date.plusDays(1);
        }

        return date;
    }

    private boolean isHoliday(LocalDate date) {
        return holidays.contains(date);
    }

    private boolean isWeekDay(LocalDate date) {
        return date.getDayOfWeek() !=
                DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY;
    }
}

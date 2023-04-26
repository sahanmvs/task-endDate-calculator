package com.mvs.taskmanagementapp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class TaskCompletionDateServiceImpl implements TaskCompletionDateService{

    private Set<LocalDate> holidays = Set.of(
            LocalDate.of(2023, Month.MAY, 1) // List of Holidays
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

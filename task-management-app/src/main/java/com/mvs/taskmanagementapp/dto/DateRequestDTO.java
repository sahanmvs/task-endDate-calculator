package com.mvs.taskmanagementapp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DateRequestDTO {
    private LocalDate startDate;
    private int numberOfDays;
}

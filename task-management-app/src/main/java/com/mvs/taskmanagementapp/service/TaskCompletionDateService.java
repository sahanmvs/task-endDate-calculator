package com.mvs.taskmanagementapp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface TaskCompletionDateService {
    LocalDate calTaskCompletionDate(LocalDate startDate, int numberOfDays);
}

package com.mvs.taskmanagementapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskCompletionDateServiceTest {

    @Autowired
    private TaskCompletionDateService dateService;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Get endDate when startDate and numberOfDays to complete is given")
    public void testCalculateTaskEndDate() {
        LocalDate startDate = LocalDate.of(2023, 4, 28);
        LocalDate expectedEndDate = LocalDate.of(2023, 5, 5);
        int numOfDays = 4;
        LocalDate endDate =
                dateService.calTaskCompletionDate(startDate, numOfDays);
        assertEquals(expectedEndDate, endDate);
    }
}
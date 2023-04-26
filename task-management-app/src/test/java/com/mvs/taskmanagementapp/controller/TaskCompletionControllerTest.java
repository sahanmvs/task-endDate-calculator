package com.mvs.taskmanagementapp.controller;

import com.mvs.taskmanagementapp.service.TaskCompletionDateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskCompletionController.class)
class TaskCompletionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskCompletionDateService dateService;
    private LocalDate expectedEndDate;

    @BeforeEach
    void setUp() {
        expectedEndDate = LocalDate.of(2023, 5, 5);
    }

    @Test
    public void testCalculateCompletionDate() throws Exception {
        LocalDate startDate = LocalDate.of(2023, 4, 28);
        int numOfDays = 4;
        Mockito.when(dateService.calTaskCompletionDate(startDate, numOfDays))
                .thenReturn(expectedEndDate);

        mockMvc.perform(post("/api/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"startDate\":\"2023-04-28\", \"numberOfDays\":4}"))
                .andExpect(status().isOk());
    }
}
package com.mvs.taskmanagementapp.controller;

import com.mvs.taskmanagementapp.dto.DateRequestDTO;
import com.mvs.taskmanagementapp.service.TaskCompletionDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class TaskCompletionController {
    @Autowired
    private TaskCompletionDateService dateService;

    @PostMapping("/")
    public ResponseEntity<LocalDate> calTaskCompletionDate(@RequestBody DateRequestDTO dateRequestDTO) {
        LocalDate date =  dateService.calTaskCompletionDate(dateRequestDTO.getStartDate(),
                dateRequestDTO.getNumberOfDays());
        return ResponseEntity.ok(date);
    }
}

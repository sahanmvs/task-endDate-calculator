package com.mvs.taskmanagementapp.controller;

import com.mvs.taskmanagementapp.dto.DateRequestDTO;
import com.mvs.taskmanagementapp.service.TaskCompletionDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TaskCompletionController {
    @Autowired
    private TaskCompletionDateService dateService;

    @PostMapping("/")
    public ResponseEntity<LocalDate> calTaskCompletionDate(@RequestBody DateRequestDTO dateRequestDTO) {
        System.out.println(dateRequestDTO.getNumberOfDays());
        LocalDate date =  dateService.calTaskCompletionDate(dateRequestDTO.getStartDate(),
                dateRequestDTO.getNumberOfDays());

        return ResponseEntity.ok(date);

    }
}

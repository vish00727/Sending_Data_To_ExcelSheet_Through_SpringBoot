package com.example.poiji.staff.controller;

import com.example.poiji.staff.dto.StaffDto;
import com.example.poiji.staff.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping
@RestController
public class StaffController {

    @Autowired
    private StaffService personService;


    @GetMapping("/export-heading-to-excel")
        public ResponseEntity<byte[]> exportHeadingToExcel() throws IOException {
            return personService.ExportHeadingToExcel();
        }

        @PostMapping("/Save/employee")
        public ResponseEntity<?> saveData(@RequestBody StaffDto staffDto) {
            personService.savePerson(staffDto);
            return ResponseEntity.ok("Employee Saved Successfully");
        }
    }

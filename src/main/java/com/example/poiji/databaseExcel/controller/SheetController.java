package com.example.poiji.databaseExcel.controller;

import com.example.poiji.databaseExcel.service.SheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("saveit")
public class SheetController {
      @Autowired
      private SheetService sheetService;

        @PostMapping("/uploaddata")
        public ResponseEntity<?> uploadExcelFile(@RequestParam("file") MultipartFile file) throws IOException {
            sheetService.uploadExcelFile(file);
            return ResponseEntity.ok("Saved Successfully");
        }

    }



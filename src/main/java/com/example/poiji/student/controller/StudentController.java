package com.example.poiji.student.controller;

import com.example.poiji.student.dto.StudentDto;
import com.example.poiji.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping("SaveStudent")
    public ResponseEntity<?>saveStudent(StudentDto studentDto){
        return  studentService.saveStudent(studentDto);
    }

    @GetMapping("/download_excel")
    public ResponseEntity<byte[]> downloadExcel() throws IOException {
        byte[] excelContent = studentService.generateExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "student_data.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .body(excelContent);
    }
}

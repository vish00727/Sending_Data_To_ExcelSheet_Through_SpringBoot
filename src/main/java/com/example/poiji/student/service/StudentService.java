package com.example.poiji.student.service;

import com.example.poiji.student.dto.StudentDto;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface StudentService {

    ResponseEntity<?>saveStudent(StudentDto studentDto);


    public   byte[] generateExcel() throws IOException;


}

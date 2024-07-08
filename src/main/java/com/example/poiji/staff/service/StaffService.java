package com.example.poiji.staff.service;

import com.example.poiji.staff.dto.StaffDto;
import com.example.poiji.staff.entity.Staff;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface StaffService {

    Staff savePerson(StaffDto staffDto);

    public ResponseEntity<byte[]>ExportHeadingToExcel() throws IOException;
}

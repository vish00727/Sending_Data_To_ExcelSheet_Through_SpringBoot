package com.example.poiji.databaseExcel.service;


import com.example.poiji.databaseExcel.dto.SheetDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SheetService {
    List<SheetDto> uploadExcelFile(MultipartFile file) throws IOException;



}



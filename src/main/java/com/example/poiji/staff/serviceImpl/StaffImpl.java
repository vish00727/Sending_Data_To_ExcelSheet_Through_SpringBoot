package com.example.poiji.staff.serviceImpl;

import com.example.poiji.staff.dto.StaffDto;
import com.example.poiji.staff.entity.Staff;
import com.example.poiji.staff.repo.StaffRepo;
import com.example.poiji.staff.service.StaffService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
@Service
public class StaffImpl implements StaffService {
    @Autowired
    private StaffRepo staffRepo;
    @Override
    public Staff savePerson(StaffDto staffDto) {
        Staff staff= new Staff();
        staff.setName(staffDto.getName());
        staff.setLastName(staffDto.getLastName());
        staff.setAge(staffDto.getAge());
        staff.setMarks(staffDto.getMarks());
        return staffRepo.save(staff);
    }

    @Override
    public ResponseEntity<byte[]> ExportHeadingToExcel() throws IOException {
        String savedata = staffRepo.ExportData();
        String[] headers = savedata.split(",");

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Employee Data");

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        List<Staff> staff = staffRepo.findAll();
        int rowIdx = 1;
        for (Staff staff1 : staff) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(staff1.getName());
            row.createCell(1).setCellValue(staff1.getLastName());
            row.createCell(2).setCellValue(staff1.getMarks());
            row.createCell(3).setCellValue(staff1.getAge());

        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentDispositionFormData("attachment", "employee_data.xlsx");
        return new ResponseEntity<>(outputStream.toByteArray(), httpHeaders, HttpStatus.OK);
    }
}



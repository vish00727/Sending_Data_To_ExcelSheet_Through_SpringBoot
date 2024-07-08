package com.example.poiji.area_master.serviceImpl;
import com.example.poiji.area_master.dto.StateDto;
import com.example.poiji.area_master.entity.StateMaster;
import com.example.poiji.area_master.repo.StateRepo;
import com.example.poiji.area_master.service.StateService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class StateServiceImpl implements StateService {
    @Autowired
    private StateRepo stateRepo;
    @Override
    public ResponseEntity<?> saveState(StateDto stateDto) {
        StateMaster stm=new StateMaster();
        stm.setStateName(stateDto.getStatename());
        stm.setStateCode(stateDto.getStateCode());
        stm.setCountryMaster(stateDto.getCountryMaster());
        stateRepo.save(stm);
        return ResponseEntity.ok(stm);
      }

        @Override
        public ByteArrayOutputStream getStateDropDown() {
        List<Map<String,Object>> list=stateRepo.getStateDropDown();
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("States");
            if (!list.isEmpty()) {
                Row headerRow = sheet.createRow(0);
                Map<String, Object> firstRow = list.get(0);
                int cellIndex = 0;
                for (String key : firstRow.keySet()) {
                    headerRow.createCell(cellIndex++).setCellValue(key);
                }
                int rowIndex = 1;
                for (Map<String, Object> rowData : list) {
                    Row row = sheet.createRow(rowIndex++);
                    cellIndex = 0;
                    for (Object value : rowData.values()) {
                        Cell cell = row.createCell(cellIndex++);
                        if (value instanceof String) {
                            cell.setCellValue((String) value);
                        } else if (value instanceof Number) {
                            cell.setCellValue(((Number) value).doubleValue());
                        } else if (value != null) {
                            cell.setCellValue(value.toString());
                        }
                        }
                        }
             }
            workbook.write(outputStream);
            return outputStream;
         }  catch (IOException e) {
            throw new RuntimeException("Error generating Excel file", e);
        }
    }
}


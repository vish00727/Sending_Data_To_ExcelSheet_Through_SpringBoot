package com.example.poiji.student.serviceIMpl;
import com.example.poiji.student.dto.StudentDto;
import com.example.poiji.student.entity.Student;
import com.example.poiji.student.repo.StudentRepo;
import com.example.poiji.student.service.StudentService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
@Service
public class StudentServiceImpl implements StudentService {
@Autowired
private StudentRepo studentRepo;
    @Override
    public ResponseEntity<?> saveStudent(StudentDto studentDto) {
        Student stud= new Student();
        stud.setName(studentDto.getName());
        stud.setLastName(studentDto.getLastName());
        stud.setMarks(studentDto.getMarks());
        stud.setAge(studentDto.getAge());
         studentRepo.save(stud);
         return ResponseEntity.ok(stud);
    }



     @Autowired
     private JdbcTemplate jdbcTemplate;

     public byte[] generateExcel() throws IOException {
        String sql = "SELECT export_data_to_csv()";
        String csvContent = jdbcTemplate.queryForObject(sql, String.class);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Student Data");
        String[] rows = csvContent.split("\n");
        for (int i = 0; i < rows.length; i++) {
            Row row = sheet.createRow(i);
            String[] columns = rows[i].split(",");
            for (int j = 0; j < columns.length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(columns[j]);
            }
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        return outputStream.toByteArray();
    }
  }


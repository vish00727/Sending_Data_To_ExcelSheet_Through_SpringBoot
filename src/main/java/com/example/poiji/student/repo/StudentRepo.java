package com.example.poiji.student.repo;

import com.example.poiji.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo  extends JpaRepository<Student, Long> {
    @Query(value = "SELECT export_data_to_csv()", nativeQuery = true)
    String exportDataToCsv();
}

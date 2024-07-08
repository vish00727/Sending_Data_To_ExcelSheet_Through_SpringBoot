package com.example.poiji.staff.repo;

import com.example.poiji.staff.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StaffRepo extends JpaRepository<Staff, Long> {

    @Query(value = "select * from export_data_to_csv()",nativeQuery = true)
    String ExportData();
}

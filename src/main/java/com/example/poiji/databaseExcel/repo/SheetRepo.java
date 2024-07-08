package com.example.poiji.databaseExcel.repo;

import com.example.poiji.databaseExcel.entity.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SheetRepo extends JpaRepository<Sheet, Long> {


}

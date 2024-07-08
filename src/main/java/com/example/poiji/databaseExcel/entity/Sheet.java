package com.example.poiji.databaseExcel.entity;

import com.poiji.annotation.ExcelCellName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ExcelCellName("name")
    private String name;

    @ExcelCellName("amount")
    private Double amount;

    @ExcelCellName("number")
    private Integer number;

    @ExcelCellName("receivedDate")
    private String receivedDate;
}



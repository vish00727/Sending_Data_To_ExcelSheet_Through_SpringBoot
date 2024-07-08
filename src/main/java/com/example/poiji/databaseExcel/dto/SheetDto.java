package com.example.poiji.databaseExcel.dto;


import com.poiji.annotation.ExcelCellName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SheetDto {

    @ExcelCellName("name")
    private String name;

    @ExcelCellName("amount")
    private Double amount;

    @ExcelCellName("number")
    private Integer number=0;

    @ExcelCellName("receivedDate")
    private String receivedDate;

}

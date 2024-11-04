package com.entity;

import com.poiji.annotation.*;

import jakarta.persistence.*;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Integer id;

    @ExcelCell(0)
    // @ExcelCellName("Name")
    private String name;

    @ExcelCell(1)
    private Double amount;

    @ExcelCell(2)
    private String number;

    @ExcelCell(3)
    // @ExcelCellName("ReceivedDate")
    private String receivedDate;
}

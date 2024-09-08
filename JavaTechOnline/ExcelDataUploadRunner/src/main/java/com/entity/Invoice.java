package com.entity;

import com.poiji.annotation.*;

import jakarta.persistence.*;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Integer id;

    @ExcelCellName("Name")
    private String name;

    @ExcelCell(1)
    private Double amount;

    @ExcelCell(2)
    private String number;

    @ExcelCellName("ReceivedDate")
    private String receivedDate;
}

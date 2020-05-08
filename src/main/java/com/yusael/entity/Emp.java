package com.yusael.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emp {
    private String id;
    private String name;
    private String salary;
    private Double age;
    private Date bir;
}

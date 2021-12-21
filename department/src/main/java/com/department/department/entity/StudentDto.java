package com.department.department.entity;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {

    @Id
    private int sid;

    private int en;
    private String name;

}

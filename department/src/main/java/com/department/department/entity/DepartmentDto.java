package com.department.department.entity;

import java.util.List;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDto {

    @Id
    private int did;

    private String departmentname;

    private List<StudentDto> studentDtos;

}

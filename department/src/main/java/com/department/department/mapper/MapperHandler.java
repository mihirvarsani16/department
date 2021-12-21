package com.department.department.mapper;

import java.util.List;

import com.department.department.entity.Department;
import com.department.department.entity.DepartmentDto;
import com.department.department.entity.Student;
import com.department.department.entity.StudentDto;
import com.department.department.entity.StudentNameDto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapperHandler {

    MapperHandler INSTANCE = Mappers.getMapper(MapperHandler.class);

    @Mappings({
            @Mapping(target = "departmentname", source = "department.name"),
            @Mapping(target = "studentDtos", source = "department.students")

    })
    DepartmentDto modelToDto(Department department);

    @InheritInverseConfiguration
    Department dtoToModel(DepartmentDto departmentDto);

    StudentDto studentToDto(Student student);

    // List<StudentNameDto> studentToNameDto(List<Student> students);
    List<StudentNameDto> studentToNameDto(List<Student> students);

    Student dtoToStudent(StudentDto studentDto);

}

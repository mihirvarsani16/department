package com.department.department.mapper;

import com.department.department.entity.Department;
import com.department.department.entity.DepartmentDto;
import com.department.department.entity.Student;
import com.department.department.entity.StudentDto;
import com.department.department.entity.StudentNameDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-07T08:59:35+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class MapperHandlerImpl implements MapperHandler {

    @Override
    public DepartmentDto modelToDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setDepartmentname( department.getName() );
        departmentDto.setStudentDtos( studentListToStudentDtoList( department.getStudents() ) );
        departmentDto.setDid( department.getDid() );

        return departmentDto;
    }

    @Override
    public Department dtoToModel(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setName( departmentDto.getDepartmentname() );
        department.setStudents( studentDtoListToStudentList( departmentDto.getStudentDtos() ) );
        department.setDid( departmentDto.getDid() );

        return department;
    }

    @Override
    public StudentDto studentToDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setEn( student.getEn() );
        studentDto.setName( student.getName() );
        studentDto.setSid( student.getSid() );

        return studentDto;
    }

    @Override
    public List<StudentNameDto> studentToNameDto(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentNameDto> list = new ArrayList<StudentNameDto>( students.size() );
        for ( Student student : students ) {
            list.add( studentToStudentNameDto( student ) );
        }

        return list;
    }

    @Override
    public Student dtoToStudent(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setEn( studentDto.getEn() );
        student.setName( studentDto.getName() );
        student.setSid( studentDto.getSid() );

        return student;
    }

    protected List<StudentDto> studentListToStudentDtoList(List<Student> list) {
        if ( list == null ) {
            return null;
        }

        List<StudentDto> list1 = new ArrayList<StudentDto>( list.size() );
        for ( Student student : list ) {
            list1.add( studentToDto( student ) );
        }

        return list1;
    }

    protected List<Student> studentDtoListToStudentList(List<StudentDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Student> list1 = new ArrayList<Student>( list.size() );
        for ( StudentDto studentDto : list ) {
            list1.add( dtoToStudent( studentDto ) );
        }

        return list1;
    }

    protected StudentNameDto studentToStudentNameDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentNameDto studentNameDto = new StudentNameDto();

        studentNameDto.setName( student.getName() );

        return studentNameDto;
    }
}

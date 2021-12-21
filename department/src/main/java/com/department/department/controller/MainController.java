package com.department.department.controller;

import java.util.List;
import com.department.department.entity.Department;
import com.department.department.entity.DepartmentDto;
import com.department.department.entity.Student;
import com.department.department.entity.StudentDto;
import com.department.department.entity.StudentNameDto;
import com.department.department.handler.ResponseHandler;
import com.department.department.mapper.MapperHandler;
import com.department.department.repository.DepartmentRepository;
import com.department.department.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private MapperHandler mapperHandler;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody DepartmentDto departmentDto) {

        if (departmentDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {

            Department department = this.mapperHandler.dtoToModel(departmentDto);

            // for (Student i : department.getStudents()) {
            // i.setDepartment(department);
            // }

            this.departmentRepository.save(department);
            return ResponseEntity.status(HttpStatus.OK).body("successfully added");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable int id) {
        Department department = this.departmentRepository.findByDid(id);
        if (department == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            DepartmentDto departmentDto = this.mapperHandler.modelToDto(department);
            return ResponseEntity.status(HttpStatus.OK).body(departmentDto);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> addStudent(@PathVariable int id, @RequestBody StudentDto studentDto) {
        Department department = this.departmentRepository.findByDid(id);
        if (department == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } else {

            Student student = this.mapperHandler.dtoToStudent(studentDto);
            student.setDepartment(department);
            department.getStudents().add(student);
            this.departmentRepository.save(department);
            return ResponseEntity.status(HttpStatus.OK).body("successfully added");
        }
    }

    @GetMapping("/name/{id}")
    public ResponseEntity<?> getStudentByDepartment(@PathVariable int id) {
        List<Student> students = this.studentRepository.findStudentByDepartment(id);

        if (students.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        List<StudentNameDto> studentNameDto = this.mapperHandler.studentToNameDto(students);

        int number = this.studentRepository.totalStudent(id);
        System.out.println("number : " + number);

        String message = "total number of student is " + number;

        // return ResponseEntity.status(HttpStatus.OK).body(studentNameDto);

        return ResponseHandler.generateResponse(message, HttpStatus.OK, studentNameDto);
    }

}

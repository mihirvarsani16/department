package com.department.department.repository;

import java.util.List;

import com.department.department.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("from Student as s where s.department.did =:id")
    public List<Student> findStudentByDepartment(@Param("id") int id);

    @Query("select count(i) from Student as i where i.department.did =:id")
    public int totalStudent(@Param("id") int id);

    // @Query("select count(*) from Playlist")
    // public int verifica();
}

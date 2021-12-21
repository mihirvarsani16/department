package com.department.department.repository;

import com.department.department.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    public Department findByDid(Integer id);

}

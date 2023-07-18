package com.springboot.studentInfoProject.Repository;

import com.springboot.studentInfoProject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}

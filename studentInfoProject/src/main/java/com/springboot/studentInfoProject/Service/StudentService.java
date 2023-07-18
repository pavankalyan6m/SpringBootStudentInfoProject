package com.springboot.studentInfoProject.Service;

import com.springboot.studentInfoProject.Entity.Student;
import com.springboot.studentInfoProject.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public void loadStudentDetailsFromDB() {
        // Implementing the logic to load student details from the database
        List<Student> students = studentRepository.findAll();
        // Processing the retrieved student data as per our requirements
        for (Student student : students) {
            System.out.println("Student ID: " + student.getStudent_id());
            System.out.println("Student Name: " + student.getStudent_name());
        }
    }

    public List<Student> getAllStudentInfo() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentDetailsById(long id) {

        return studentRepository.findById(id);
        //or
        //List<Student> studentOptional = studentRepository.findById(id);
        //return studentOptional.orElse(null);
    }

    public void saveStudentDetails(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudentDetailsById(long id)
    {
        studentRepository.deleteById(id);
    }

}

package com.springboot.studentInfoProject.Controller;

import com.springboot.studentInfoProject.Entity.Student;
import com.springboot.studentInfoProject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studentInfo")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController (StudentService studentService)
    {
        this.studentService = studentService;
    }

    @GetMapping("/welcome")
    public String welcomePage() {
        return "Welcome to StudentInfo Page";
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Student> getAllStudentDetails() {
        return studentService.getAllStudentInfo();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentDetailsById(id);
    }

    @PostMapping("/new")
    public void saveStudentInfo(@RequestBody Student student) {
        studentService.saveStudentDetails(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentInfoById(@PathVariable Long id) { // Added @PathVariable annotation
        studentService.deleteStudentDetailsById(id);
    }
}

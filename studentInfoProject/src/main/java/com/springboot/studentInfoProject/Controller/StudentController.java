package com.springboot.studentInfoProject.Controller;

import com.springboot.studentInfoProject.Entity.Student;
import com.springboot.studentInfoProject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studentInfo")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/welcome")
    public String welcomePage()
    {
        return "Welcome to StudentInfo Page";
    }

    @GetMapping("/all")
    public List<Student> getAllStudentDetails()
    {
        return studentService.getAllStudentInfo();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id)
    {
        return studentService.getStudentDetailsById(id);
    }

    @PostMapping("/new")
    public void saveStudentInfo(@RequestBody Student student)
    {
        studentService.saveStudentDetails(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentInfoById(Long id)
    {
        studentService.deleteStudentDetailsById(id);
    }

}

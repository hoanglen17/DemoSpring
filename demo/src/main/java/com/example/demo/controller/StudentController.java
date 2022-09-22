package com.example.demo.controller;

import com.example.demo.student.Student;
import com.example.demo.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(value = "/hi")
    public String hello(){
        return "Hi";
    }

    @GetMapping(value = "/getStudent")
    public List<Student> service(){
        return studentService.getStudent();
    }

    @PostMapping(value = "/addStudent")
    public  void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PutMapping(value = "/updateStudent/{id}")
    public  void updateStudent(@PathVariable Long id, @RequestBody Student student){
    studentService.updateStudent(id,student);
    }

    @DeleteMapping(value = "/deleteStudent/{id}")
    public  void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}

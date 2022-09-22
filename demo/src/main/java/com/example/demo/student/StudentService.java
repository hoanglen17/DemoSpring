package com.example.demo.student;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudent() {
        return studentRepo.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> studentFindByEmail = studentRepo.findStudentByEmail(student.getEmail());
        if(studentFindByEmail.isPresent()){
            throw new IllegalStateException("Email Token");
        }
        studentRepo.save(student);
    }

    public void deleteStudent(Long id) {
        Optional<Student> studentFindById = studentRepo.findById(id);
        if(studentFindById.isPresent()){
            studentRepo.delete(studentFindById.get());
        }else {
            throw new IllegalStateException("Student Not Found");
        }
    }

    public void updateStudent(Long id, Student studentDto) {
        Student studentFindById = studentRepo.findById(id).get();
        if(studentFindById != null) {
            studentFindById.updateStudent(studentDto);
            studentRepo.save(studentFindById);
        }else {
            throw new IllegalStateException("Student Not Found");
        }
    }
}

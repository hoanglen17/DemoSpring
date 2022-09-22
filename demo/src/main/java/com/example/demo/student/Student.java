package com.example.demo.student;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity(name = "student")
@Table
@Data
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String name;
    private String email;
    private LocalDate DOB;
    private String address;
    private Integer age;

    @Transient
    public Integer getAge(){
        return Period.between(this.DOB,LocalDate.now()).getYears();
    }

    @Transient
    public void updateStudent(Student studentDto) {
        this.name = studentDto.getName();
        this.email = studentDto.getEmail();
        this.DOB = studentDto.getDOB();
        this.address = studentDto.getAddress();
    }
}

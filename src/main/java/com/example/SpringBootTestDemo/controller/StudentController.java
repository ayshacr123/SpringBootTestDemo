package com.example.SpringBootTestDemo.controller;


import com.example.SpringBootTestDemo.entity.Student;
import com.example.SpringBootTestDemo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    private final Logger LOGGER = LoggerFactory.getLogger((StudentController.class));

    @Autowired
    private StudentService studentservices;

    @PostMapping("/addstudent")
    public Student addStudents(@Valid @RequestBody Student student){
        LOGGER.info("Inside StudentController addstudent method, RequestBody : {}", student);
        return studentservices.addStudent(student);
    }

    @GetMapping("/getstudent")
    public List<Student> getAllStudentss(){
        return studentservices.getAllStudents();
    }

    @GetMapping("/getstudent/{student-id}")
    public Student getByStudentIds(@PathVariable("student-id") int id){
        return studentservices.getByStudentId(id);
    }

    @GetMapping("/name/{student-name}")
    public List<Student> getStudentByNames(@PathVariable("student-name") String name){
        return studentservices.getStudentByName(name);
    }


    @DeleteMapping("/delete/{student-id}")
    public Student deleteStudentByIds(@PathVariable("student-id") int id){
        return studentservices.deleteStudentById(id);
    }


}

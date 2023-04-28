package com.example.SpringBootTestDemo.service;

import com.example.SpringBootTestDemo.entity.Student;
import com.example.SpringBootTestDemo.exception.StudentNotFoundException;
import com.example.SpringBootTestDemo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceClass implements StudentService{

    @Autowired
    private StudentRepo repo;

    @Override
    public Student addStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Student getByStudentId(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Student deleteStudentById(int id) {
        Optional<Student> s= repo.findById(id);
        if(!s.isPresent()){
            throw new StudentNotFoundException("Student with id "+ id +" not found/exist");
        }
        repo.deleteById(id);
        return null;
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return repo.findByName(name);
    }
}

package com.example.demo.controllers;

import com.example.demo.models.student;
import com.example.demo.repositories.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class studentController {

    @Autowired
    private studentRepository studentRepository;

    @GetMapping
    public List<student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<student> getStudentById(@PathVariable int id) {
        return studentRepository.findById(id);
    }

    @PostMapping
    public student createStudent(@RequestBody student newStudent) {
        return studentRepository.save(newStudent);
    }

    @PutMapping("/{id}")
    public student updateStudent(@PathVariable int id, @RequestBody student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    updatedStudent.setId(id);
                    return studentRepository.save(updatedStudent);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentRepository.deleteById(id);
    }
}
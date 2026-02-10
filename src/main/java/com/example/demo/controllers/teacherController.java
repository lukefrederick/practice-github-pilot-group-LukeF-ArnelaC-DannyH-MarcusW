package com.example.demo.controllers;

import com.example.demo.models.teacher;
import com.example.demo.repositories.teacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class teacherController {

    @Autowired
    private teacherRepository teacherRepository;

    @GetMapping
    public List<teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<teacher> getTeacherById(@PathVariable int id) {
        return teacherRepository.findById(id);
    }

    @PostMapping
    public teacher createTeacher(@RequestBody teacher newTeacher) {
        return teacherRepository.save(newTeacher);
    }

    @PutMapping("/{id}")
    public teacher updateTeacher(@PathVariable int id, @RequestBody teacher updatedTeacher) {
        return teacherRepository.findById(id)
                .map(teacher -> {
                    teacher.setName(updatedTeacher.getName());
                    return teacherRepository.save(teacher);
                })
                .orElseGet(() -> {
                    updatedTeacher.setId(id);
                    return teacherRepository.save(updatedTeacher);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable int id) {
        teacherRepository.deleteById(id);
    }
}

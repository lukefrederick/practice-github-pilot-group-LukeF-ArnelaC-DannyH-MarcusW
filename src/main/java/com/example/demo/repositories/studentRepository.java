package com.example.demo.repositories;

import com.example.demo.models.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<student, Integer> {
}
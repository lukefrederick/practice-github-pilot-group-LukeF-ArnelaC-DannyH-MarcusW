package com.example.demo.repositories;

import com.example.demo.models.teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface teacherRepository extends JpaRepository<teacher, Integer> {
}
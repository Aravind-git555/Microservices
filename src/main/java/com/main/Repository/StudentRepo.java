package com.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}

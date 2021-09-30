package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {

}

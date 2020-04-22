package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Category  extends JpaRepository<com.example.demo.entity.Category,Integer>{

}

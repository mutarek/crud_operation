package com.example.demo.repository;

import com.example.demo.models.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogsRepository extends JpaRepository<Blogs,Integer> {
}

package com.example.tuwaiqacademylab12.Repository;

import com.example.tuwaiqacademylab12.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    List<Blog> findByTitle(String title);

}
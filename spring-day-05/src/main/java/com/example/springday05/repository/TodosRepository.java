package com.example.springday05.repository;

import com.example.springday05.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface TodosRepository extends JpaRepository<Todo, Integer> {
    List<Todo> getByStatus(Boolean status);
}

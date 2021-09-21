package com.example.demo.repository;

import com.example.demo.model.Persoon;
import org.springframework.data.repository.CrudRepository;

public interface PersoonRepository extends CrudRepository<Persoon, Long> {
    Iterable<Persoon> findByAchternaam(String lastname);
}

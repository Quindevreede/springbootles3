package com.example.demo.service;

import com.example.demo.model.Persoon;

public interface PersoonService {

    Iterable<Persoon> findAll();
    public Persoon findById(long nr);
    void save(Persoon persoon);
    void deleteById(long nr);
    Iterable<Persoon> findByLastname(String lastname);

}
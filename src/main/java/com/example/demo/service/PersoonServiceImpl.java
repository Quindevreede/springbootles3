package com.example.demo.service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Persoon;
import com.example.demo.repository.PersoonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PersoonServiceImpl implements PersoonService {

    private PersoonRepository persoonRepository;

    @Autowired //met constructor
    public PersoonServiceImpl(PersoonRepository persoonRepository) {
        this.persoonRepository = persoonRepository;
    }

    public Iterable<Persoon> findAll() {
        Iterable<Persoon> personen = persoonRepository.findAll();
        return personen;
    }

    public Persoon findById(long nr) {
        Optional<Persoon> persoon = persoonRepository.findById(nr);
        if (persoon.isPresent()) {
            return persoon.get();
        }
        else {
            throw new RecordNotFoundException("Persoon with id " + nr + " not found");
        }
    }

    public void save(Persoon persoon) {
        persoonRepository.save(persoon);
    }

    public void deleteById(long nr) {
        try {
            persoonRepository.deleteById(nr);
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            throw new RecordNotFoundException();
        }
    }

    @Override
    public Iterable<Persoon> findByLastname(String lastname) {
        return persoonRepository.findByAchternaam(lastname);
    }
}

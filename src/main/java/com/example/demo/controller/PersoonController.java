package com.example.demo.controller;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Persoon;
import com.example.demo.repository.PersoonRepository;
import com.example.demo.service.PersoonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// De imports die grijs zijn WERDEN voorheen gebruikt in de code,
// maar de code is zo aangepast dat ze niet meer gebruikt worden,
// dus staan er nu alleen zodat ik kan zien hoe we begonnen waren.

@RestController
public class PersoonController {

    @Autowired
    private PersoonService persoonService;

    @GetMapping(value = "/personen")
    public ResponseEntity getPersonen(@RequestParam("achternaam") String achternaam) {
        Iterable<Persoon> personen;
        if (achternaam.isEmpty()) {
            personen = persoonService.findAll();
        }
        else {
            personen = persoonService.findByLastname(achternaam);
        }
        return ResponseEntity.ok(personen);
    }

    /* Als voorbeeld hier de @GetMapping zoals die was toen t via de REPOSITORY ging nu dus via SERVICE
    @GetMapping(value = "/personen")
    public ResponseEntity getPersonen() {
        Iterable<Persoon> personen = persoonRepository.findAll();
        return ResponseEntity.ok(personen);
    }

    @GetMapping(value = "/personen/{nr}")
    public ResponseEntity getPersoon(@PathVariable long nr) {
        try {
            Optional<Persoon> persoon = persoonRepository.findById(nr);
            return ResponseEntity.ok(persoon);
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            throw new RecordNotFoundException();
        }
    }
    @GetMapping(value = "/personen/{nr}")
    public ResponseEntity getPersoon(@PathVariable long nr) {
        Persoon persoon = persoonService.findById(nr);
        return ResponseEntity.ok(persoon);
    }
*/

    @PostMapping(value = "/personen")
    public ResponseEntity addPersoon(@RequestBody Persoon persoon) {
        persoonService.save(persoon);
        return ResponseEntity.ok("Toegevoegd");
    }

    @DeleteMapping(value = "/personen/{nr}")
    public ResponseEntity deletePersoon(@PathVariable long nr) {
        persoonService.deleteById(nr);
        return ResponseEntity.ok("Verwijderd");
    }

    @PutMapping(value = "/personen/{nr}")
    public ResponseEntity updatePersoon(@PathVariable long nr, @RequestBody Persoon persoon) {
        return ResponseEntity.ok("Aangepast");
    }

}
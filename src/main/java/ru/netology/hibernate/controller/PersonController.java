package ru.netology.hibernate.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {
    private final PersonRepository repository;

    @GetMapping("/by-city")
    public List<Person> findAllByCityOfLiving(@RequestParam String city) {
        return repository.findAllByCityOfLiving(city);
    }

    @GetMapping("/less-than-age")
    public List<Person> findAllByAgeLessThanOrderByAgeAsc(@RequestParam int age) {
        return repository.findAllByPersonId_AgeLessThanOrderByPersonId_AgeAsc(age);
    }

    @GetMapping("/by-name-and-surname")
    public Person findByNameAndSurname(@RequestParam("name") String name,
                                       @RequestParam("surname") String surname) {
        return repository.findByPersonId_NameAndPersonId_Surname(name, surname).
                orElseThrow(EntityNotFoundException::new);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
    }

}

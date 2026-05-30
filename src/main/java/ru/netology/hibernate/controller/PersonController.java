package ru.netology.hibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {
    private final PersonRepository repository;

    @Secured("ROLE_READ")
    @GetMapping("/by-city")
    public List<Person> findAllByCityOfLiving(@RequestParam String city) {
        return repository.findAllByCityOfLiving(city);
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/less-than-age")
    public List<Person> findAllByAgeLessThanOrderByAgeAsc(@RequestParam int age) {
        return repository.findAllByPersonId_AgeLessThanOrderByPersonId_AgeAsc(age);
    }

    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    @GetMapping("/by-name-and-surname")
    public Person findByNameAndSurname(@RequestParam("name") String name,
                                       @RequestParam("surname") String surname) {
        return repository.findByPersonId_NameAndPersonId_Surname(name, surname).
                orElseThrow(EntityNotFoundException::new);
    }

    @PreAuthorize("#username == authentication.name")
    @GetMapping("/user-data")
    public String getData(@RequestParam String username) {
        return "Access granted for " + username;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
    }

}

package ru.netology.hibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {
    private final PersonRepository repository;

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return repository.getPersonsByCity(city);
    }
}

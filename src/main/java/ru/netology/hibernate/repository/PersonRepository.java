package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.entity.PersonId;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
    List<Person> findAllByCityOfLiving(String cityOfLiving);

    List<Person> findAllByPersonId_AgeLessThanOrderByPersonId_AgeAsc(int age);

    Optional<Person> findByPersonId_NameAndPersonId_Surname(String name, String surname);
}

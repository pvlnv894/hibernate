package ru.netology.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "persons")
public class Person {
    @EmbeddedId
    private PersonId personId;
    private String phoneNumber;
    private String cityOfLiving;
}

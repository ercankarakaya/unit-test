package com.ercan.entity;

import com.ercan.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "person",orphanRemoval = true) //(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();
}

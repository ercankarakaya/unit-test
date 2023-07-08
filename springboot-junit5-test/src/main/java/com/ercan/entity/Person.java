package com.ercan.entity;

import com.ercan.enums.Gender;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}

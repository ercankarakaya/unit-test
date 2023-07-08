package com.ercan.entity;

import com.ercan.enums.AddressType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String address;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "person_address_id")
    private Person person;
}

package com.ercan.entity;

import com.ercan.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String address;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    private Boolean active;

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "person_address_id")
    @JsonIgnore
    private Person person;

    public Address(String address) {
        this.address = address;
    }
}

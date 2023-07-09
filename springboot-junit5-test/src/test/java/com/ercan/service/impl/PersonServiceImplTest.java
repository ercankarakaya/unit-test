package com.ercan.service.impl;

import com.ercan.dto.PersonDto;
import com.ercan.entity.Address;
import com.ercan.entity.Person;
import com.ercan.enums.AddressType;
import com.ercan.enums.Gender;
import com.ercan.mapper.PersonMapper;
import com.ercan.repository.AddressRepository;
import com.ercan.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @InjectMocks
    private PersonServiceImpl personService;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private PersonMapper personMapper;

    private PersonDto personDto;


    @BeforeEach
    void setUp() {
        personDto = PersonDto.builder()
                .firstName("john")
                .lastName("wick")
                .addresses(Arrays.asList(new Address("example-address")))
                .gender(Gender.MALE.name())
                .build();
    }

    @Test
    void testSave() {
        Person personMock = mock(Person.class);
        when(personMapper.toPerson(any())).thenReturn(personMock);
        when(personMock.getId()).thenReturn(1L);
        when(personRepository.save(any(Person.class))).thenReturn(personMock);

        PersonDto result = personService.save(personDto);

        assertEquals(result.getFirstName(), personDto.getFirstName());
        assertEquals(result.getId(), 1l);
    }

    @Test
    void testSaveException() {
        personDto = new PersonDto();
        personDto.setLastName("wick");
        personDto.setAddresses(Arrays.asList(new Address("example-address")));

        assertThrows(IllegalArgumentException.class, ()->personService.save(personDto));
    }

    @Test
    void testGetPersonById() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void testGetAllPerson() {
    }

}
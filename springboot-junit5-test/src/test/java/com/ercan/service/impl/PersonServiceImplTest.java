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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    void testGetAllPerson() {
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("john");
        person.setLastName("wick");
        person.setGender(Gender.MALE);
        person.setEmail("ercan@gmail.com");

        when(personRepository.findAll()).thenReturn(Collections.singletonList(person));

        List<PersonDto> personDtos = personService.getAllPerson();

        assertEquals(personDtos.size(),1);
        //assertEquals(personDtos.get(0),PersonDto.builder().id(1L).build());
    }

    @Test
    void testGetPersonById() {
    }

    @Test
    void testDelete() {
    }

}
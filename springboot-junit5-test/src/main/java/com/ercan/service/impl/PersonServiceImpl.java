package com.ercan.service.impl;

import com.ercan.dto.PersonDto;
import com.ercan.repository.AddressRepository;
import com.ercan.repository.PersonRepository;
import com.ercan.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;


    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {
        return null;
    }

    @Override
    public PersonDto getPersonById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDto> getAllPerson() {
        return null;
    }
}

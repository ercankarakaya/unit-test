package com.ercan.service;

import com.ercan.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto save(PersonDto personDto);

    PersonDto getPersonById(Long id);

    void delete(Long id);

    List<PersonDto> getAllPerson();
}

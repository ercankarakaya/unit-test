package com.ercan.service.impl;

import com.ercan.dto.PersonDto;
import com.ercan.entity.Address;
import com.ercan.entity.Person;
import com.ercan.enums.AddressType;
import com.ercan.exception.PersonNotFoundException;
import com.ercan.mapper.PersonMapper;
import com.ercan.repository.AddressRepository;
import com.ercan.repository.PersonRepository;
import com.ercan.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;
    private final PersonMapper personMapper;

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {

        Assert.notNull(personDto.getFirstName(),"Firstname is required!");

        Person personSaved = personRepository.save(personMapper.toPerson(personDto));

        List<Address> addressList = new ArrayList<>();
        personDto.getAddresses().forEach(item->{
            Address address = new Address();
            address.setAddress(item.getAddress());
            address.setAddressType(AddressType.WORK);
            address.setActive(true);
            address.setPerson(personSaved);
            addressList.add(address);
        });

        addressRepository.saveAll(addressList);

        personDto.setId(personSaved.getId());
        personDto.setAddresses(addressList);

        return personDto;
    }

    @Override
    public PersonDto getPersonById(Long id) {
        return personMapper.toPersonDto(personRepository.findById(id)
                .orElseThrow(()->new PersonNotFoundException("Person not found!")));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDto> getAllPerson() {
        return null;
    }


    /*
    private Person toPerson(PersonDto personDto){
        Person person = new Person();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setAddresses(personDto.getAddresses());
        person.setGender(Gender.valueOf(personDto.getGender()));
        return person;
    }
     */
}

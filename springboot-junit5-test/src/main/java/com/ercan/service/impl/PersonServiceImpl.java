package com.ercan.service.impl;

import com.ercan.dto.PersonDto;
import com.ercan.entity.Address;
import com.ercan.entity.Person;
import com.ercan.enums.AddressType;
import com.ercan.mapper.PersonMapper;
import com.ercan.repository.AddressRepository;
import com.ercan.repository.PersonRepository;
import com.ercan.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

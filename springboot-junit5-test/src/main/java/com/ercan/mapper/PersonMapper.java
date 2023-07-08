package com.ercan.mapper;

import com.ercan.dto.PersonDto;
import com.ercan.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Named("toPerson")
    Person toPerson(PersonDto personDto);

    @Named("toPersonDto")
    PersonDto toPersonDto(Person person);
}

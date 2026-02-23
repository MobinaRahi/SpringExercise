package com.mftplus.workExperience.mapper;

import com.mftplus.workExperience.dto.PersonDto;
import com.mftplus.workExperience.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDto toDto(Person person);
    Person toEntity(PersonDto personDto);
}

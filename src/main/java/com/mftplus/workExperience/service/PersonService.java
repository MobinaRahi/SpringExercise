package com.mftplus.workExperience.service;

import com.mftplus.workExperience.dto.PersonDto;
import com.mftplus.workExperience.mapper.PersonMapper;
import com.mftplus.workExperience.model.Person;
import com.mftplus.workExperience.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public void save(PersonDto personDto) {
        Person person = personMapper.toEntity(personDto);
        personRepository.save(person);
    }

    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }
}

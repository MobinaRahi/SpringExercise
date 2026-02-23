package com.mftplus.workExperience.runner;


import com.mftplus.workExperience.dto.PersonDto;
import com.mftplus.workExperience.dto.WorkExperienceDto;
import com.mftplus.workExperience.service.PersonService;
import com.mftplus.workExperience.service.WorkExperienceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Slf4j
@Component
public class Main implements CommandLineRunner {
    private final WorkExperienceService workExperienceService;
    private final PersonService personService;

    @Override
    public void run(String... args) throws Exception {
        PersonDto personDto1 =
                PersonDto
                        .builder()
                        .firstName("mobina")
                        .lastName("Doe")
                        .build();

        PersonDto personDto2 =
                PersonDto
                        .builder()
                        .firstName("zeynab")
                        .lastName("Doe")
                        .build();

        personService.save(personDto1);
        personService.save(personDto2);
        log.info("personDto1={}, personDto2={} saved", personDto1.getFirstName(), personDto2.getFirstName());
        WorkExperienceDto workExperienceDto =
                WorkExperienceDto
                        .builder()
                        .personId(1L)
                        .companyName("dotin")
                        .jobTitle("programmer")
                        .startYear(LocalDate.of(2020, 1, 1))
                        .endYear(LocalDate.of(2025, 1, 1))
                        .description("programmer")
                        .build();
        workExperienceService.save(workExperienceDto);
        log.info("WorkExperience saved successfully");

    }
}

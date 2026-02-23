package com.mftplus.service;

import com.mftplus.workExperience.dto.PersonDto;
import com.mftplus.workExperience.dto.WorkExperienceDto;
import com.mftplus.workExperience.repository.WorkExperienceRepository;
import com.mftplus.workExperience.service.PersonService;
import com.mftplus.workExperience.service.WorkExperienceServiceImp;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;


@ExtendWith(MockitoExtension.class)
@Log4j2
public class WorkExperienceServiceTest {
    @Mock
    private WorkExperienceRepository workExperienceRepository;

    @InjectMocks
    private WorkExperienceServiceImp workExperienceServiceImp;
    private PersonService personService;
    private WorkExperienceDto workExperienceDto;
    private PersonDto personDto1;

    @BeforeEach
    public void setup() {
        personDto1 =
                PersonDto
                        .builder()
                        .firstName("mobina")
                        .lastName("Doe")
                        .build();


        personService.save(personDto1);

        log.info("personDto1={} saved", personDto1.getFirstName());
        workExperienceDto =
                WorkExperienceDto
                        .builder()
                        .personId(1L)
                        .companyName("dotin")
                        .jobTitle("programmer")
                        .startYear(LocalDate.of(2020, 1, 1))
                        .endYear(LocalDate.of(2025, 1, 1))
                        .description("programmer")
                        .build();
    }

    @Test
    public void saveWorkExperience() {
        workExperienceServiceImp.save(workExperienceDto);
    }


}

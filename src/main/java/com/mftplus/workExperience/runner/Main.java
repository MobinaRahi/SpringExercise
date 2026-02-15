package com.mftplus.workExperience.runner;


import com.mftplus.workExperience.dto.WorkExperienceDto;
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
    @Override
    public void run(String... args) throws Exception {
        WorkExperienceDto workExperienceDto =
                WorkExperienceDto
                        .builder()
                        .person("mobina")
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

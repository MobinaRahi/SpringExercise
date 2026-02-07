package com.mftplus.workExperience.controller;


import com.mftplus.workExperience.service.WorkExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/work_experiences")
@RequiredArgsConstructor
public class WorkExperienceController {
    private final WorkExperienceService workExperienceService;

    @GetMapping
    public String workExperience() {
        return "workExperience";
    }
}

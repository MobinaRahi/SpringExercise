package com.mftplus.workExperience.controller;


import com.mftplus.workExperience.dto.WorkExperienceDto;
import com.mftplus.workExperience.service.WorkExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/work_experiences")
@RequiredArgsConstructor
public class WorkExperienceController {
    private final WorkExperienceService workExperienceService;

    @GetMapping
    public String getAllWorkExperience(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            Model model
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        model.addAttribute("workExperiences", workExperienceService.findAll(pageable));
        model.addAttribute("workExperience", new WorkExperienceDto());
        return "workExperience";
    }
    @GetMapping("/update/{id}")
    public String updateWorkExperienceForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("workExperience", workExperienceService.findById(id));
        return "update";
    }

    @PostMapping
    public String addWorkExperience(@Valid @ModelAttribute("workExperience") WorkExperienceDto workExperienceDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "workExperience";
        }
        workExperienceService.save(workExperienceDto);
        return "redirect:/work_experiences";
    }

    @PutMapping
    public String updateWorkExperience(@RequestBody WorkExperienceDto workExperienceDto) {
        workExperienceService.update(workExperienceDto);
        return "workExperience";
    }
}

package com.mftplus.workExperience.mapper;

import com.mftplus.workExperience.dto.WorkExperienceDto;
import com.mftplus.workExperience.model.WorkExperience;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkExperienceMapper {
    WorkExperience toEntity(WorkExperienceDto workExperienceDto);

    WorkExperienceDto toDto(WorkExperience workExperience);
}

package org.example.forkliftaccountsystem.model.mappers;

import org.example.forkliftaccountsystem.model.dto.ForkliftDto;
import org.example.forkliftaccountsystem.model.dto.ForkliftResponseDto;
import org.example.forkliftaccountsystem.model.entity.Forklift;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ForkliftMapper {

    Forklift toEntity(ForkliftDto forkliftDto);

    List<ForkliftResponseDto> toDto(List<Forklift> forklifts);

    ForkliftResponseDto toDto(Forklift forklift);
}


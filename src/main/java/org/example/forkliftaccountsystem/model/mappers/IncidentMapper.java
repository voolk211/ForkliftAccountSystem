package org.example.forkliftaccountsystem.model.mappers;

import org.example.forkliftaccountsystem.model.dto.IncidentDto;
import org.example.forkliftaccountsystem.model.dto.IncidentResponseDto;
import org.example.forkliftaccountsystem.model.entity.Incident;
import org.mapstruct.Mapper;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IncidentMapper {

    Incident toEntity(IncidentDto incidentDto);

    List<IncidentResponseDto> toDto(List<Incident> incidents);

    default IncidentResponseDto toDto(Incident incident) {
        IncidentResponseDto responseDto = new IncidentResponseDto();
        responseDto.setId(incident.getId());
        responseDto.setStartTime(incident.getStartTime());

        LocalDateTime end = incident.getEndTime() != null ? incident.getEndTime() : LocalDateTime.now();

        Duration duration = Duration.between(incident.getStartTime(), end);

        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();

        String downtime = hours + "ч " + minutes + " мин";

        responseDto.setEndTime(incident.getEndTime() != null ? incident.getEndTime() : null);
        responseDto.setDowntime(downtime);
        responseDto.setDescription(incident.getDescription());
        return responseDto;
    }

}


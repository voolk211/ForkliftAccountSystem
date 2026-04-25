package org.example.forkliftaccountsystem.service;

import org.example.forkliftaccountsystem.model.dto.IncidentResponseDto;
import org.example.forkliftaccountsystem.model.entity.Incident;

import java.util.List;

public interface IncidentService {

    List<IncidentResponseDto> getIncidents(Long forkliftId);

    IncidentResponseDto createIncident(Incident incident, Long id);

    IncidentResponseDto updateIncident(Incident incident, Long id);

    void deleteIncident(Long id);

}

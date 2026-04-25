package org.example.forkliftaccountsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.forkliftaccountsystem.exception.ResourceNotFoundException;
import org.example.forkliftaccountsystem.model.dto.IncidentResponseDto;
import org.example.forkliftaccountsystem.model.entity.Incident;
import org.example.forkliftaccountsystem.model.mappers.IncidentMapper;
import org.example.forkliftaccountsystem.repository.ForkliftRepository;
import org.example.forkliftaccountsystem.repository.IncidentRepository;
import org.example.forkliftaccountsystem.service.IncidentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentServiceImpl implements IncidentService {

    private final IncidentRepository incidentRepository;
    private final ForkliftRepository forkliftRepository;

    private final IncidentMapper incidentMapper;

    @Transactional
    @Override
    public IncidentResponseDto createIncident(Incident incident, Long id) {
        incident.setForklift(forkliftRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Forklift not found")));
        Incident createdIncident = incidentRepository.save(incident);
        return incidentMapper.toDto(createdIncident);
    }

    @Transactional(readOnly = true)
    @Override
    public List<IncidentResponseDto> getIncidents(Long id) {
        List<Incident> incidents = incidentRepository.findByForkliftIdOrderByStartTimeDesc(id);
        return incidentMapper.toDto(incidents);
    }

    @Transactional
    @Override
    public IncidentResponseDto updateIncident(Incident incident, Long id) {
        Incident currentIncident = getIncidentOrThrow(id);
        if (incident.getStartTime() != null) {
            currentIncident.setStartTime(incident.getStartTime());
        }
        if (incident.getDescription() != null) {
            currentIncident.setDescription(incident.getDescription());
        }
        currentIncident.setEndTime(incident.getEndTime());
        Incident createdIncident = incidentRepository.save(currentIncident);
        return incidentMapper.toDto(createdIncident);
    }

    @Transactional
    @Override
    public void deleteIncident(Long id) {
        incidentRepository.deleteById(id);
    }

    private Incident getIncidentOrThrow(Long id) {
        return incidentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Incident not found"));
    }
}

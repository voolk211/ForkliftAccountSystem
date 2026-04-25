package org.example.forkliftaccountsystem.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.forkliftaccountsystem.model.dto.IncidentResponseDto;
import org.example.forkliftaccountsystem.model.entity.Forklift;
import org.example.forkliftaccountsystem.model.dto.IncidentDto;
import org.example.forkliftaccountsystem.model.entity.Incident;
import org.example.forkliftaccountsystem.model.mappers.IncidentMapper;
import org.example.forkliftaccountsystem.service.IncidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/incidents")
@RequiredArgsConstructor
public class IncidentController {

    private final IncidentService incidentService;

    private final IncidentMapper incidentMapper;

    @PutMapping("/{id}")
    public ResponseEntity<IncidentResponseDto> updateIncident(@Valid @RequestBody IncidentDto incidentDto, @PathVariable Long id) {
        IncidentResponseDto newIncident = incidentService.updateIncident(incidentMapper.toEntity(incidentDto), id);
        return ResponseEntity.ok(newIncident);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncident(@PathVariable Long id) {
        incidentService.deleteIncident(id);
        return ResponseEntity.noContent().build();
    }

}

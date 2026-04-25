package org.example.forkliftaccountsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.forkliftaccountsystem.model.dto.ForkliftResponseDto;
import org.example.forkliftaccountsystem.model.dto.IncidentResponseDto;
import org.example.forkliftaccountsystem.model.entity.Forklift;
import org.example.forkliftaccountsystem.model.entity.Incident;
import org.example.forkliftaccountsystem.model.dto.ForkliftDto;
import org.example.forkliftaccountsystem.model.dto.IncidentDto;
import org.example.forkliftaccountsystem.model.mappers.ForkliftMapper;
import org.example.forkliftaccountsystem.model.mappers.IncidentMapper;
import org.example.forkliftaccountsystem.service.ForkliftService;
import org.example.forkliftaccountsystem.service.IncidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forklifts")
@RequiredArgsConstructor
public class ForkliftController {

    private final ForkliftService forkliftService;
    private final IncidentService incidentService;

    private final ForkliftMapper forkliftMapper;
    private final IncidentMapper incidentMapper;

    @GetMapping
    public ResponseEntity<List<ForkliftResponseDto>> getForkliftById(
            @RequestParam(required = false) String number) {
        List<ForkliftResponseDto> forklifts = forkliftService.getForklifts(number);
        return ResponseEntity.ok(forklifts);
    }

    @PostMapping
    public ResponseEntity<ForkliftResponseDto> createForklift(@Valid @RequestBody ForkliftDto forkliftDto) {
        ForkliftResponseDto newForklift = forkliftService.createForklift(forkliftMapper.toEntity(forkliftDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(newForklift);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ForkliftResponseDto> updateForklift(@Valid @RequestBody ForkliftDto forkliftDto, @PathVariable Long id) {
        ForkliftResponseDto newForklift = forkliftService.updateForklift(forkliftMapper.toEntity(forkliftDto), id);
        return ResponseEntity.ok(newForklift);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForkliftById(@PathVariable Long id) {
        forkliftService.deleteForklift(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/incidents")
    public ResponseEntity<List<IncidentResponseDto>> getIncidentsById(@PathVariable Long id) {
        List<IncidentResponseDto> incidents = incidentService.getIncidents(id);
        return ResponseEntity.ok(incidents);
    }

    @PostMapping("{id}/incidents")
    public ResponseEntity<IncidentResponseDto> createIncident(@Valid @RequestBody IncidentDto incidentDto, @PathVariable Long id) {
        IncidentResponseDto incident = incidentService.createIncident(incidentMapper.toEntity(incidentDto), id);
        return ResponseEntity.status(HttpStatus.CREATED).body(incident);
    }

}

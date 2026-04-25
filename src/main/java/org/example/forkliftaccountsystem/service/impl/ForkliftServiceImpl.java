package org.example.forkliftaccountsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.forkliftaccountsystem.exception.IncidentsExistException;
import org.example.forkliftaccountsystem.exception.ResourceNotFoundException;
import org.example.forkliftaccountsystem.model.dto.ForkliftResponseDto;
import org.example.forkliftaccountsystem.model.entity.Forklift;
import org.example.forkliftaccountsystem.model.mappers.ForkliftMapper;
import org.example.forkliftaccountsystem.repository.ForkliftRepository;
import org.example.forkliftaccountsystem.repository.IncidentRepository;
import org.example.forkliftaccountsystem.service.ForkliftService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ForkliftServiceImpl implements ForkliftService {

    private final ForkliftRepository forkliftRepository;
    private final IncidentRepository incidentRepository;

    private final ForkliftMapper forkliftMapper;

    @Transactional
    @Override
    public ForkliftResponseDto createForklift(Forklift forklift) {
        if (forklift.getNumber() != null && forkliftRepository.existsByNumber(forklift.getNumber())){
            throw new IllegalStateException("Number already in use");
        }
        return forkliftMapper.toDto(forkliftRepository.save(forklift));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ForkliftResponseDto> getForklifts(String number) {
        List<Forklift> forklifts = (number == null || number.isBlank())
                ? forkliftRepository.findAll()
                : forkliftRepository.findByNumberContainingIgnoreCase(number);
        return forkliftMapper.toDto(forklifts);
    }

    @Transactional
    @Override
    public ForkliftResponseDto updateForklift(Forklift forklift, Long id) {
        Forklift currentForklift = getForkliftOrThrow(id);
        if (forklift.getNumber() != null && forkliftRepository.existsByNumber(forklift.getNumber()) && !(currentForklift.getNumber().equals(forklift.getNumber()))) {
            throw new IllegalStateException("Number already in use");
        }
        if (forklift.getNumber() != null) {
            currentForklift.setNumber(forklift.getNumber());
        }
        if (forklift.getActive() != null) {
            currentForklift.setActive(forklift.getActive());
        }
        if (forklift.getBrand() != null) {
            currentForklift.setBrand(forklift.getBrand());
        }
        if (forklift.getCapacity() != null) {
            currentForklift.setCapacity(forklift.getCapacity());
        }
        if (forklift.getUsername() != null) {
            currentForklift.setUsername(forklift.getUsername());
        }
        return forkliftMapper.toDto(forkliftRepository.save(currentForklift));
    }

    @Transactional
    @Override
    public void deleteForklift(Long id) {
        if (incidentRepository.existsByForklift_Id(id)) {
            throw new IncidentsExistException("Forklift has incidents");
        }
        forkliftRepository.deleteById(id);
    }

    private Forklift getForkliftOrThrow(Long id) {
        return forkliftRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Forklift not found"));
    }

}

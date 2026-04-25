package org.example.forkliftaccountsystem.service;


import org.example.forkliftaccountsystem.model.dto.ForkliftDto;
import org.example.forkliftaccountsystem.model.dto.ForkliftResponseDto;
import org.example.forkliftaccountsystem.model.entity.Forklift;

import java.util.List;

public interface ForkliftService {

    List<ForkliftResponseDto> getForklifts(String number);

    ForkliftResponseDto createForklift(Forklift forklift);

    ForkliftResponseDto updateForklift(Forklift forklift, Long id);

    void deleteForklift(Long id);

}

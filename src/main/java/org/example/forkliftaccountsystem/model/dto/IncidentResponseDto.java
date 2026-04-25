package org.example.forkliftaccountsystem.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class IncidentResponseDto {

    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String description;

    private String downtime;
}

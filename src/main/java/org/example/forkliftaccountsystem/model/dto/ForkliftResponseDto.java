package org.example.forkliftaccountsystem.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ForkliftResponseDto {

    private Long id;

    private String username;

    private String brand;

    private String number;

    private BigDecimal capacity;

    private Boolean active;

    private LocalDateTime updatedAt;

}

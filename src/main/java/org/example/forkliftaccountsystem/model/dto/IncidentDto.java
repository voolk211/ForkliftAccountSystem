package org.example.forkliftaccountsystem.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class IncidentDto {

        @NotNull(message = "Start time must not be null")
        @DateTimeFormat
        private LocalDateTime startTime;

        @DateTimeFormat
        private LocalDateTime endTime;

        @NotBlank(message = "description must not be blank")
        @Length(max = 255, message = "description length must not exceed 255 characters")
        private String description;

}

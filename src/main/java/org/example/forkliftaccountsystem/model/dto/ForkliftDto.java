package org.example.forkliftaccountsystem.model.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ForkliftDto {

    @NotBlank(message = "Username must not be blank")
    @Length(max = 255, message = "Username length must not exceed 255 characters")
    private String username;

    @NotBlank(message = "Brand must not be blank")
    @Length(max = 255, message = "Brand length must not exceed 255 characters")
    private String brand;

    @NotBlank(message = "Number must not be blank")
    @Length(max = 255, message = "Number length must not exceed 255 characters")
    private String number;

    @NotNull(message = "Capacity must not be null")
    @PositiveOrZero(message = "Capacity must greater or equal to than zero")
    private BigDecimal capacity;

    private Boolean active;

}

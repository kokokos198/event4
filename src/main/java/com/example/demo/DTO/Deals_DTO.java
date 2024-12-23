package com.example.demo.DTO;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Deals_DTO {

@Min(0)
@Max(1000000)
@NotNull
    private Long costs;

    @NotNull
    @NotEmpty
    private String number;


    @NotNull
    private Long ClientID;

    @NotNull
    @NotEmpty
    private String FO;
}

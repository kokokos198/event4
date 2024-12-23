package com.example.demo.Mappers;

import com.example.demo.DTO.Deals_DTO;
import com.example.demo.Entity.Deals;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class Deals_Mapper_Impliments {
  public Deals toEntity(Deals_DTO dto) {
    return Deals.builder()
            .costs(dto.getCosts())
            .ClientID(dto.getClientID())
            .number(dto.getNumber())
            .FO(dto.getFO()).build();
  }

  public Deals_DTO toDTO(Deals deals) {
    return Deals_DTO.builder()
            .costs(deals.getCosts())
            .ClientID(deals.getClientID())
            .number(deals.getNumber())
            .FO(deals.getFO()).build();
  }

}


package com.example.demo.Mappers;

import com.example.demo.DTO.Deals_DTO;
import com.example.demo.Entity.Deals;

public interface Deals_Mapper extends Mapp<Deals_DTO, Deals> {
    Deals toEntity(Deals_DTO dealsDto);
    Deals_DTO  toDTO(Deals deals);
}

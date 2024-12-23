package com.example.demo.Mappers;

import com.example.demo.DTO.Deals_DTO;
import com.example.demo.Entity.Deals;

public interface Mapp<D, E> {
    E toEntity(D d);
    D toDTO(E e);
}

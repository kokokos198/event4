package com.example.demo.web.controller;

import com.example.demo.DTO.Deals_DTO;
import com.example.demo.Entity.Deals;
import com.example.demo.Service.DealsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class DealsControllerTest {


@Mock
DealsService dealsService;

@InjectMocks
DealsController dealsController;

    @Test
    void createDeal() {
    Deals_DTO dealsDto = new Deals_DTO(656, "656", 65, "hgf");

}






    void createDeals() {

    }

}

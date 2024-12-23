package com.example.demo.web.controller;

import com.example.demo.DTO.Deals_DTO;
import com.example.demo.Entity.Deals;
import com.example.demo.Mappers.Deals_Mapper;
import com.example.demo.Mappers.Deals_Mapper_Impliments;
import com.example.demo.Service.DealsService;
import com.example.demo.Validation.OnCreate;
import com.example.demo.Validation.OnUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;



@RestController
@RequestMapping("/rest_api/deals")
//@NoArgsConstructor
//@RequiredArgsConstructor
public class DealsController{
    @Autowired(required = false)
    private  final DealsService dealsService;
    private final Deals_Mapper_Impliments deal_map;

    public DealsController (DealsService dealsService, Deals_Mapper_Impliments deal_map)
{
    this.dealsService = dealsService;
    this.deal_map = deal_map;
}

     @PutMapping("/update/{id}")
    public Deals_DTO updateDeals(@Validated @PathVariable("id") Long id, @RequestBody Deals_DTO dealsDto)
    {
        Deals deals = deal_map.toEntity(dealsDto);
        return deal_map.toDTO(dealsService.update(deals, id));
    }

    @PostMapping("/create_deals")
    public Deals_DTO createDeals(@RequestBody @Validated Deals_DTO dealsDto)
    {
        Deals deals= deal_map.toEntity(dealsDto);
        return deal_map.toDTO(dealsService.create(deals));
    }

    @PostMapping(value = "/upl", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Integer> uploadCSVFile(@RequestParam("file") MultipartFile file,
    @RequestParam ("name") String name) throws IOException {

        return ResponseEntity.ok(dealsService.uploadcsv(file));
    }

    @GetMapping("/{id}")
    public Deals_DTO getDeaalsbyid(@PathVariable  Long id)
    {
        return  deal_map.toDTO(dealsService.getDeals(id));
    }

    @DeleteMapping("/{id}")
    void deletebyid(@PathVariable  Long id)
    {
        dealsService.delete(id);
    }
}

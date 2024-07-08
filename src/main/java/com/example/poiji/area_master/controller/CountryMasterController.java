package com.example.poiji.area_master.controller;

import com.example.poiji.area_master.dto.CountryDto;
import com.example.poiji.area_master.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

 @RestController
 @RequestMapping
 @CrossOrigin(origins = "*")
 public class CountryMasterController {

    @Autowired
    private CountryService countryService;
    @PostMapping("/country")
    public ResponseEntity<?>saveCountry( @RequestBody CountryDto countryDto){
        return countryService.saveCountry(countryDto);
    }
 }

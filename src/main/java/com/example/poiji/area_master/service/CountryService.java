package com.example.poiji.area_master.service;

import com.example.poiji.area_master.dto.CountryDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

public interface CountryService {
    ResponseEntity<?>saveCountry(CountryDto countryDto);
}

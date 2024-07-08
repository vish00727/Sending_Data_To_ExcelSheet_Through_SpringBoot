package com.example.poiji.area_master.serviceImpl;

import com.example.poiji.area_master.dto.CountryDto;
import com.example.poiji.area_master.entity.CountryMaster;
import com.example.poiji.area_master.repo.CountryRepo;
import com.example.poiji.area_master.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepo countryRepo;
    @Override
    public ResponseEntity<?> saveCountry(CountryDto countryDto) {
        CountryMaster ctm= new CountryMaster();
        ctm.setName(countryDto.getName());
        ctm.setCountryCode(countryDto.getCountryCode());
        countryRepo.save(ctm);
        return ResponseEntity.ok(ctm);
    }


}

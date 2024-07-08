package com.example.poiji.area_master.dto;

import com.example.poiji.area_master.entity.CountryMaster;
import lombok.Getter;
import lombok.Setter;

 @Getter
 @Setter
 public class StateDto {

    private String Statename;

    private Long stateCode;

    private CountryMaster countryMaster;
  }

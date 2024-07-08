package com.example.poiji.area_master.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StateMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stateName;

    private Long stateCode;

    @ManyToOne
    @JoinColumn(name = "Country_id")
    private CountryMaster countryMaster;
}

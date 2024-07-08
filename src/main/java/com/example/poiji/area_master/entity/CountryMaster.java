package com.example.poiji.area_master.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
@Entity
@Table(name = "country")
public class CountryMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name;

    private Long countryCode;
}

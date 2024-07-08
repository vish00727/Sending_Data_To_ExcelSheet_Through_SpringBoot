package com.example.poiji.area_master.service;

import com.example.poiji.area_master.dto.StateDto;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;

public interface StateService {
    ResponseEntity<?>saveState(StateDto stateDto);
    ByteArrayOutputStream getStateDropDown();
}

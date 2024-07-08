package com.example.poiji.area_master.controller;

import com.example.poiji.area_master.dto.StateDto;
import com.example.poiji.area_master.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping
@CrossOrigin
public class StateController {
    @Autowired
    private StateService stateService;

    @PostMapping("/saveState")
    public ResponseEntity<?>saveState(@RequestBody StateDto stateDto){
        return stateService.saveState(stateDto);
    }

    @GetMapping("/stateDropDown")
    public ResponseEntity<?> getStateDropDown() {
        ByteArrayOutputStream outputStream = stateService.getStateDropDown();
        byte[] bytes = outputStream.toByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "states.xlsx");
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }

}

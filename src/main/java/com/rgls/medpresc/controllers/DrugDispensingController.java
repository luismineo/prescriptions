package com.rgls.medpresc.controllers;

import com.rgls.medpresc.dtos.DrugDescriptionDto;
import com.rgls.medpresc.model.DrugDispensing;
import com.rgls.medpresc.services.DrugDispensingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drugDispensing")
public class DrugDispensingController {

    @Autowired
    private DrugDispensingService drugDispensingService;

    @GetMapping
    public ResponseEntity<List<DrugDispensing>> getAllDispensing(){
        return ResponseEntity.ok(drugDispensingService.findAllDrugDispensing());
    }

    @PostMapping
    public ResponseEntity<Void> CreateDispensing(@RequestBody DrugDescriptionDto drugDispensing){
        try {
            drugDispensingService.dispensingPrescription(drugDispensing);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}

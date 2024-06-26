package com.rgls.medpresc.controllers;

import com.rgls.medpresc.dtos.MedicAndPharmacyDto;
import com.rgls.medpresc.model.Medic;
import com.rgls.medpresc.model.Pharmacy;
import com.rgls.medpresc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/medic")
    public ResponseEntity<Void> postMedic(@RequestBody Medic medic) {
        try {
            service.createMedic(medic);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/pharmacy")
    public ResponseEntity<Void> postPharmacy(@RequestBody Pharmacy pharmacy) {
        try {
            service.createPharmacy(pharmacy);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<MedicAndPharmacyDto> getMedicAndPharmacy() {
        List<Medic> medics = service.findAllMedics();
        List<Pharmacy> pharmacies = service.findAllPharmacy();
        MedicAndPharmacyDto dto = new MedicAndPharmacyDto(medics, pharmacies);
        return ResponseEntity.ok(dto);
    }
}

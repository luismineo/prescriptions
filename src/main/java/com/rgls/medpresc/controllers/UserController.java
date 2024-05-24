package com.rgls.medpresc.controllers;

import ch.qos.logback.core.joran.sanity.Pair;
import com.rgls.medpresc.dtos.MedicAndPharmacyDto;
import com.rgls.medpresc.model.Medic;
import com.rgls.medpresc.model.Pharmacy;
import com.rgls.medpresc.model.User;
import com.rgls.medpresc.services.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/medic")
    public ResponseEntity<Void> postMedic(@RequestBody Medic medic){
        try{
            service.CreateMedic(medic);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/pharmacy")
    public ResponseEntity<Void> postPharmacy(@RequestBody Pharmacy pharmacy){
        try{
            service.CreatePharmacy(pharmacy);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<MedicAndPharmacyDto> getMedic(){
        var user = service.FindUsers();
        MedicAndPharmacyDto dto = new MedicAndPharmacyDto(user.a, user.b);
        return ResponseEntity.ok(dto);
    }
}

package com.rgls.medpresc.controllers;

import com.rgls.medpresc.model.Medic;
import com.rgls.medpresc.model.Pharmacy;
import com.rgls.medpresc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

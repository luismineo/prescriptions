package com.rgls.medpresc.controllers;

import com.rgls.medpresc.model.Prescription;
import com.rgls.medpresc.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<Void> postPrescription(@RequestBody Prescription prescription) {
        try {
            prescriptionService.createPrescription(prescription);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Prescription>> getAllPrescription(){
        return ResponseEntity.ok(prescriptionService.findAllPrescriptions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getByIdPrescription(@PathVariable Long id){
        Optional<Prescription> prescription = prescriptionService.findByIdPrescription(id);

        // return prescription.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        if (prescription.isPresent()) {
            return ResponseEntity.ok(prescription.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescription) {
        Prescription updatedUser = prescriptionService.editPrescription(prescription, id);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

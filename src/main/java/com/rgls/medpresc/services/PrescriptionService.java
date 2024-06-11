package com.rgls.medpresc.services;

import com.rgls.medpresc.model.Prescription;
import com.rgls.medpresc.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public void createPrescription(Prescription prescription) {
        try {
            prescriptionRepository.save(prescription);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    public List<Prescription> findAllPrescriptions(){
        return prescriptionRepository.findAll();
    }

    public Optional<Prescription> findByIdPrescription(Long id){
        return prescriptionRepository.findById(id);
    }

    public Prescription editPrescription(Prescription prescription, Long id){
        try {
            Prescription editPres = prescriptionRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Prescription not found"));

            editPres.setPatient(prescription.getPatient());
            editPres.setPatient(prescription.getPatient());
            editPres.setMedic(prescription.getMedic());
            editPres.setSendDate(prescription.getSendDate());
            editPres.setDosage(prescription.getDosage());
            editPres.setQuantity(prescription.getQuantity());
            editPres.setAdminMethod(prescription.getAdminMethod());
            editPres.setObservations(prescription.getObservations());
            editPres.setDigitalSignature(prescription.getDigitalSignature());

            return prescriptionRepository.save(editPres);
        }
        catch (RuntimeException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void deletePrescription(Long id){
        try{
            Prescription removePres = prescriptionRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Prescription not found"));

            prescriptionRepository.delete(removePres);
        }
        catch (RuntimeException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}

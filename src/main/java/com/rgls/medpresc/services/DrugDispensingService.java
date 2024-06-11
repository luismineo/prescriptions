package com.rgls.medpresc.services;

import com.rgls.medpresc.dtos.DrugDescriptionDto;
import com.rgls.medpresc.model.DrugDispensing;
import com.rgls.medpresc.repositories.DrugDispensingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DrugDispensingService {
    @Autowired
    private DrugDispensingRepository drugDispensingRepository;

    @Autowired
    private PrescriptionService prescriptionService;
    public void dispensingPrescription(DrugDescriptionDto dispensing){
        try{
            Long idPrescription = dispensing.getPrescription().getId();
            var prescription = prescriptionService.findByIdPrescription(idPrescription);
            if (prescription.isEmpty()){
                throw new RuntimeException("prescription not exist");
            }

            DrugDispensing drug = DrugDispensing.builder()
                    .dispensingDate(new Date())
                    .pharmaceuticalInCharge(dispensing.getPharmaceuticalInCharge())
                    .dispensingQuantity(dispensing.getDispensingQuantity())
                    .prescription(dispensing.getPrescription()).build();

            drugDispensingRepository.save(drug);

        } catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<DrugDispensing> findAllDrugDispensing(){
        return drugDispensingRepository.findAll();
    }
}

package com.rgls.medpresc.services;

import com.rgls.medpresc.model.Medic;
import com.rgls.medpresc.model.Pharmacy;
import com.rgls.medpresc.model.User;
import com.rgls.medpresc.repositories.MedicRepository;
import com.rgls.medpresc.repositories.PharmacyRepository;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private MedicRepository medicRepository;

    @Autowired
    private PharmacyRepository pharmacyRepository;

    public void createMedic(Medic medic){
        try{
            medicRepository.save(medic);
        }catch (RuntimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void createPharmacy(Pharmacy pharmacy){
        try{
            pharmacyRepository.save(pharmacy);
        }catch (RuntimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    public List<Medic> findAllMedics(){
        return medicRepository.findAll();
    }
    public List<Pharmacy> findAllPharmacy(){
        return pharmacyRepository.findAll();
    }
}

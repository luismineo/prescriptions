package com.rgls.medpresc.dtos;

import com.rgls.medpresc.model.Medic;
import com.rgls.medpresc.model.Pharmacy;
import lombok.Getter;

import java.util.List;

@Getter
public class MedicAndPharmacyDto {
    private List<Medic> medicList;
    private List<Pharmacy> pharmacyList;

    public MedicAndPharmacyDto(List<Medic> medicList, List<Pharmacy> pharmacyList) {
        this.medicList = medicList;
        this.pharmacyList = pharmacyList;
    }
}

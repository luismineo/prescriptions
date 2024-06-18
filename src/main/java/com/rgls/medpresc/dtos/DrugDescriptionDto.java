package com.rgls.medpresc.dtos;

import com.rgls.medpresc.model.Prescription;
import lombok.Getter;

@Getter
public class DrugDescriptionDto {
    private Prescription prescription;
    private String dispensingQuantity;
    private String pharmaceuticalInCharge;
}

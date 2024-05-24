package com.rgls.medpresc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class DrugDispensing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "receita_id")
    private Prescription prescription;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dispensingDate;

    private String dispensingQuantity;
    private String pharmaceuticalInCharge;
}

package com.rgls.medpresc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Prescription> prescription;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(unique = true)
    private String cpf;
}

package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "medic_id")
    private Medic medic;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sendDate;

    @Lob
    private String drugs;
    private String dosage;
    private String quantity;
    private String admnMethod;
    private String observations;
    private String digitalSignature;
}

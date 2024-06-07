package com.rgls.medpresc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import com.rgls.medpresc.model.enums.Role;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Medic extends User{
    private String crm;
    private String certDigital;

    @OneToMany(mappedBy = "medic")
    @JsonIgnore
    private List<Prescription> prescription;

    public Medic(Long id, String firstName, String lastName, String username, String password, Set<Role> roles, String crm, String certDigital) {
        super(id, firstName, lastName, username, password, roles);
        this.crm = crm;
        this.certDigital = certDigital;
    }

    public Medic() {}
}

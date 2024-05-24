package com.rgls.medpresc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    private List<Prescription> prescription;

    public Medic(Long id, String firstName, String lastName, String username, String password, Set<Role> roles, String crm, String certDigital) {
        super(id, firstName, lastName, username, password, roles);
        this.crm = crm;
        this.certDigital = certDigital;
    }

    public Medic() {
    }
    /*
    public Medic(){
        this.getRoles().add(Role.MEDIC);
    }
     */
}

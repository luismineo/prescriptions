package model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import model.enums.Role;

@Getter
@Setter
@Entity
public class Medic extends User{
    private String crm;
    private String certDigital;

    public Medic(){
        this.getRoles().add(Role.MEDIC);
    }
}

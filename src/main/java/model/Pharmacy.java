package model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import model.enums.Role;

@Getter
@Setter
@Entity
public class Pharmacy extends User{
    private String cnpj;

    public Pharmacy(){
        this.getRoles().add(Role.PHARMACY);
    }
}

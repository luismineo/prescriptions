package com.rgls.medpresc.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import com.rgls.medpresc.model.enums.Role;

import java.util.Set;

@Getter
@Setter
@Entity
public class Pharmacy extends User{
    private String cnpj;

    public Pharmacy(Long id, String firstName, String lastName, String username, String password, Set<Role> roles, String cnpj) {
        super(id, firstName, lastName, username, password, roles);
        this.cnpj = cnpj;
    }

    public Pharmacy() {}
}

package ca.cal.tp2.Modele;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class Utilisateur {
    private String nom;
    private String email;
    private String phone;

    public Utilisateur(String nom, String email, String phone) {
        this.nom = nom;
        this.email = email;
        this.phone = phone;
    }

    public abstract void login();
}
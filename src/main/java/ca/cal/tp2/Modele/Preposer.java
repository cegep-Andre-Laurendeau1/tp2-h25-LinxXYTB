package ca.cal.tp2.Modele;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class Preposer extends Utilisateur {
 
    @Override
    public void login() {
        System.out.println("Login");
    }

    public void entrerNouveauDocument(Document document) {
        System.out.println("Entrer un nouveau document");
    }

    public void collecteAmende(Emprunteur emprunteur, double montant) {
        System.out.println("Collecte amende");
    }

    public void rapportAmendes() {
        System.out.println("Rapport des amendes");
    }

    public void rapportEmprunts() {
        System.out.println("Rapport des emprunts");
    }
}

package ca.cal.tp2.Modele;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("Emprunteur")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Emprunteur extends Utilisateur {
    @OneToMany(mappedBy = "emprunteur")
    private List<Amende> amendes;

    @OneToMany(mappedBy = "emprunteur")
    private List<Emprunt> emprunts;

    public Emprunteur(String nom, String email, String phone, List<Amende> amendes, List<Emprunt> emprunts) {
        super(nom, email, phone);
        this.amendes = (amendes == null) ? new ArrayList<>() : amendes;
        this.emprunts = (emprunts == null) ? new ArrayList<>() : emprunts;
    }

    @Override
    public void login() {
        System.out.println("Login");
    }

    public void emprunt(Document document) {
        System.out.println("Emprunt");
    }

    public void retourneDocument(Document document) {
        System.out.println("Retourne document");
    }

    public void payerAmende(double montant) {
        System.out.println("Payer amende");
    }

    public void rapportHistoirique() {
        System.out.println("Rapport historique");
    }
}
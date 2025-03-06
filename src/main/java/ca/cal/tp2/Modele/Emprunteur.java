package ca.cal.tp2.Modele;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Emprunteur extends Utilisateur {
    @OneToMany
    private List<Amende> amendes;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    public Emprunteur(String nom, String email, String phone, List<Amende> amendes) {
        super(nom, email, phone);
        this.amendes = amendes;
    }

    public Emprunteur(String nom, String email, String phone) {
        super(nom, email, phone);
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
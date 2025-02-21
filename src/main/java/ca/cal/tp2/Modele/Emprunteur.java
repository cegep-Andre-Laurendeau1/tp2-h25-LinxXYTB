package ca.cal.tp1.Modele;

import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
public class Emprunteur extends Utilisateur {
    
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

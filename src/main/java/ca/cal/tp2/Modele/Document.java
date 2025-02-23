package ca.cal.tp2.Modele;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public abstract class Document {
    private final int documentID;
    private final String titre;
    private final int nombreExemplaires;

    public void verifieDisponibilite() {
        System.out.println("Vérifie disponibilité");
    }
}

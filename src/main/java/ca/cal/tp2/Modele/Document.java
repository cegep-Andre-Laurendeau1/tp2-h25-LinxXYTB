package ca.cal.tp2.Modele;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@SuperBuilder(toBuilder = true)
@Getter
@Setter
@ToString
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private String titre;
    private int nombreExemplaires;

    public void verifieDisponibilite() {
        System.out.println("Vérifie disponibilité");
    }

    public Document(String titre, int nombreExemplaires) {
        this.titre = titre;
        this.nombreExemplaires = nombreExemplaires;
    }
}

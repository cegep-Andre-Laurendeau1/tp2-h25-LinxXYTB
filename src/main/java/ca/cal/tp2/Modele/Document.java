package ca.cal.tp2.Modele;

import java.util.List;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private String titre;
    private int nombreExemplaires;
    
    @OneToMany(mappedBy = "document")
    protected List<EmpruntDetail> empruntDetails;

    public boolean verifieDisponibilite() {
        return nombreExemplaires > 0;
    }

    public Document(String titre, int nombreExemplaires, List<EmpruntDetail> empruntDetails) {
        this.titre = titre;
        this.nombreExemplaires = nombreExemplaires;
        this.empruntDetails = empruntDetails;
    }
}

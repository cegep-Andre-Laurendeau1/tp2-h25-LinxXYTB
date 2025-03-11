package ca.cal.tp2.Modele;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@DiscriminatorValue("DVD")
@ToString(callSuper = true)@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class DVD extends Document {
    
    
    private String directeur;
    private String rating;
    private int duree;

    public DVD() {
        super("", 0, null);
    }

    public DVD(String titre, int nombreExemplaires, String directeur, String rating, int duree, List<EmpruntDetail> empruntDetails) {
        super(titre, nombreExemplaires, empruntDetails);
        this.directeur = directeur;
        this.rating = rating;
        this.duree = duree;
    }
}

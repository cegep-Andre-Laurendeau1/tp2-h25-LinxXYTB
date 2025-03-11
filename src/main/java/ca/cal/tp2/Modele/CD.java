package ca.cal.tp2.Modele;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@DiscriminatorValue("CD")
@ToString(callSuper = true)
@Getter
@Setter
public class CD extends Document {
    
    private String artiste;
    private String genre;
    private int duree;

    public CD() {
        super("", 0, null);
    }

    public CD(String titre, int nombreExemplaires, String artiste, String genre, int duree, List<EmpruntDetail> empruntDetails) {
        super(titre, nombreExemplaires, empruntDetails);
        this.artiste = artiste;
        this.genre = genre;
        this.duree = duree;
    }

}

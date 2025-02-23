package ca.cal.tp2.Modele;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
public class Livre extends Document {
    
    private final String ISBN;
    private final String auteur;
    private final String editeur;
    private final int nombrePages;
}

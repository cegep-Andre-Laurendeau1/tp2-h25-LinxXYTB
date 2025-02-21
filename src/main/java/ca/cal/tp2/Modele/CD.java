package ca.cal.tp1.Modele;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;


@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
public class CD extends Document {
    
    private final String artiste;
    private final String genre;
    private final int duree;

}

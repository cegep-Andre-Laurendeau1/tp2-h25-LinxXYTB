package ca.cal.tp1.Modele;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;


@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
public class DVD extends Document {
    
    private final String directeur;
    private final String rating;
    private final int duree;

}

package ca.cal.tp2.Modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Entity
@DiscriminatorValue("Livre")
@ToString(callSuper = true)@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
public class DVD extends Document {
    
    private final String directeur;
    private final String rating;
    private final int duree;

}

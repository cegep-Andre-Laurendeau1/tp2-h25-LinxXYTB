package ca.cal.tp2.Service.DTO;

import ca.cal.tp2.Modele.Amende;
import java.time.LocalDate;

public record AmendeDTO(int id, double montant, LocalDate date, boolean status) {
    public static AmendeDTO toDTO(Amende amende) {
        return new AmendeDTO(amende.getID(), amende.getMontant(), amende.getDateCreation(), amende.isStatus());
    }

}

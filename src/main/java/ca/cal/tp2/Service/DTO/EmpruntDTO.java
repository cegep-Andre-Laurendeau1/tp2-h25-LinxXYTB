package ca.cal.tp2.Service.DTO;

import java.time.LocalDate;
import java.util.List;

import ca.cal.tp2.Modele.Emprunt;

public record EmpruntDTO(int id, LocalDate dateEmprunt, String status, List<EmpruntDetailDTO> empruntDetails, EmprunteurDTO emprunteur) {
    
    public static EmpruntDTO toDTO(Emprunt emprunt) {
        return new EmpruntDTO(
            emprunt.getID(),
            emprunt.getDateEmprunt(),
            emprunt.getStatus(),
            emprunt.getEmpruntDetail().stream().map(EmpruntDetailDTO::toDTO).toList(),
            EmprunteurDTO.toDTO(emprunt.getEmprunteur())
        );
    }

    public static Emprunt toModele(EmpruntDTO empruntDTO) {
        return new Emprunt(
            empruntDTO.dateEmprunt(),
            empruntDTO.status(),
            empruntDTO.empruntDetails().stream().map(EmpruntDetailDTO::toModele).toList(),
            EmprunteurDTO.toModele(empruntDTO.emprunteur())
        );
    }
}
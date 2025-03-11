package ca.cal.tp2.Service.DTO;

import java.time.LocalDate;

import ca.cal.tp2.Modele.Emprunt;
import ca.cal.tp2.Modele.EmpruntDetail;

public record EmpruntDetailDTO(int id, LocalDate dateRetourPrevu, LocalDate dateRetourActuelle, String status, int empruntId, DocumentDTO document) {
    
    public static EmpruntDetailDTO toDTO(EmpruntDetail empruntDetail) {
        return new EmpruntDetailDTO(
            empruntDetail.getId(),
            empruntDetail.getDateRetrourPrevu(),
            empruntDetail.getDateRetourActuelle(),
            empruntDetail.getStatus(),
            empruntDetail.getEmprunt().getID(),
            DocumentDTO.toDTO(empruntDetail.getDocument())
        );
    }

    public static EmpruntDetail toModele(EmpruntDetailDTO empruntDetailDTO) {
        Emprunt emprunt = new Emprunt();
        emprunt.setID(empruntDetailDTO.empruntId());
        return new EmpruntDetail(
            empruntDetailDTO.dateRetourPrevu(),
            empruntDetailDTO.dateRetourActuelle(),
            empruntDetailDTO.status(),
            emprunt,
            DocumentDTO.toModele(empruntDetailDTO.document())
        );
    }
}
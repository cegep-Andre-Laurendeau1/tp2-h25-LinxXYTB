package ca.cal.tp2.Service.DTO;

import ca.cal.tp2.Modele.CD;

public record CDDTO(String titre, int nombreExemplaires, String artist, String genre, int duree) {
    public CD toCD( CDDTO cdDTO) {
        return new CD(cdDTO.titre(), cdDTO.nombreExemplaires(), cdDTO.artist(), cdDTO.genre(), cdDTO.duree());
    }
}

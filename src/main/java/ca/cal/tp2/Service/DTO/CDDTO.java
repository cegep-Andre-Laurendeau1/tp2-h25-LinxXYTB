package ca.cal.tp2.Service.DTO;

import java.util.List;
import java.util.stream.Collectors;

import ca.cal.tp2.Modele.CD;

public record CDDTO(String titre, int nombreExemplaires, String artist, String genre, int duree, List<EmpruntDetailDTO> empruntDetailDTO) {
    public CD toCD( CDDTO cdDTO) {
        return new CD(cdDTO.titre(), cdDTO.nombreExemplaires(), cdDTO.artist(), cdDTO.genre(), cdDTO.duree(), empruntDetailDTO.stream().map(EmpruntDetailDTO::toModele).collect(Collectors.toList()));
    }
}

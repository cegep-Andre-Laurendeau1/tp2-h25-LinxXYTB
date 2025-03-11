package ca.cal.tp2.Service.DTO;

import java.util.List;
import java.util.stream.Collectors;

import ca.cal.tp2.Modele.DVD;

public record DVDDTO(String titre, int nombreExemplaires, String directeur, String rating, int duree, List<EmpruntDetailDTO> empruntDetailDTO) {
    public DVD toDVD(DVDDTO dvdDTO) {
        return new DVD(dvdDTO.titre(), dvdDTO.nombreExemplaires(), dvdDTO.directeur(), dvdDTO.rating(), dvdDTO.duree(), empruntDetailDTO.stream().map(EmpruntDetailDTO::toModele).collect(Collectors.toList()));
    }
    

}

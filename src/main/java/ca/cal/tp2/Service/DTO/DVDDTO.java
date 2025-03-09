package ca.cal.tp2.Service.DTO;

import ca.cal.tp2.Modele.DVD;

public record DVDDTO(String titre, int nombreExemplaires, String directeur, String rating, int duree) {
    public DVD toDVD(DVDDTO dvdDTO) {
        return new DVD(dvdDTO.titre(), dvdDTO.nombreExemplaires(), dvdDTO.directeur(), dvdDTO.rating(), dvdDTO.duree());
    }
    

}

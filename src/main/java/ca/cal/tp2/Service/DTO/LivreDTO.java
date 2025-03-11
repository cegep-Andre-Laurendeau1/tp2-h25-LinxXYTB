package ca.cal.tp2.Service.DTO;

import java.util.List;
import java.util.stream.Collectors;

import ca.cal.tp2.Modele.Livre;

public record LivreDTO( String titre, int nombreExemplaires, String ISBN, String auteur, String editeur, int nombrePages, List<EmpruntDetailDTO> empruntDetailDTO) {
    public Livre toLivre (LivreDTO livreDTO) {
        return new Livre(livreDTO.titre(), livreDTO.nombreExemplaires(), livreDTO.ISBN(), livreDTO.auteur(), livreDTO.editeur(), livreDTO.nombrePages(), empruntDetailDTO.stream().map(EmpruntDetailDTO::toModele).collect(Collectors.toList()));
    }

}

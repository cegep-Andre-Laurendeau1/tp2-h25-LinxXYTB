package ca.cal.tp2.Service.DTO;

import ca.cal.tp2.Modele.Livre;

public record LivreDTO( String titre, int nombreExemplaires, String ISBN, String auteur, String editeur, int nombrePages) {
    public Livre toLivre (LivreDTO livreDTO) {
        return new Livre(livreDTO.titre(), livreDTO.nombreExemplaires(), livreDTO.ISBN(), livreDTO.auteur(), livreDTO.editeur(), livreDTO.nombrePages());
    }

}

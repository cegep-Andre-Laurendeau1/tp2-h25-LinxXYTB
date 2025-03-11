package ca.cal.tp2.Service.DTO;

import java.util.List;

import ca.cal.tp2.Modele.CD;
import ca.cal.tp2.Modele.DVD;
import ca.cal.tp2.Modele.Document;
import ca.cal.tp2.Modele.Livre;
import ca.cal.tp2.Modele.EmpruntDetail;
public record DocumentDTO(int id, String titre, int nombreExemplaires, List<EmpruntDetail> empruntDetails, String type, String ISBN, String auteur, String editeur, int nombrePages, String directeur, String rating, int duree, String artiste, String genre) {

    public static DocumentDTO toDTO(Document document) {
        if (document instanceof Livre) {
            return new DocumentDTO(document.getID() ,document.getTitre(), document.getNombreExemplaires(), document.getEmpruntDetails(), "Livre", ((Livre) document).getISBN(), ((Livre) document).getAuteur(), ((Livre) document).getEditeur(), ((Livre) document).getNombrePages(), null, null, 0, null, null);
        } else if (document instanceof CD) {
            return new DocumentDTO(document.getID(), document.getTitre(), document.getNombreExemplaires(), document.getEmpruntDetails(), "CD", null, null, null, 0, null, null, 0, ((CD) document).getArtiste(), ((CD) document).getGenre());
        } else if (document instanceof DVD) {
            return new DocumentDTO(document.getID(), document.getTitre(), document.getNombreExemplaires(), document.getEmpruntDetails(), "DVD", null, null, null, 0, ((DVD) document).getDirecteur(), ((DVD) document).getRating(), ((DVD) document).getDuree(), null, null);
        }
        return null;
    }

    public static Document toModele(DocumentDTO document) {
        if (document == null) {return null;}
        if (document.type().equals("Livre")) {
            return new Livre(document.titre(), document.nombreExemplaires(), document.ISBN(), document.auteur(), document.editeur(), document.nombrePages(), document.empruntDetails());
        } else if (document.type().equals("CD")) {
            return new CD(document.titre(), document.nombreExemplaires(), document.artiste(), document.genre(), document.duree(), document.empruntDetails());
        } else if (document.type().equals("DVD")) {
            return new DVD(document.titre(), document.nombreExemplaires(), document.directeur(), document.rating(), document.duree(), document.empruntDetails());
        }
        return null;
    }
    
} 

package ca.cal.tp2.Service.DTO;

import java.util.List;

import ca.cal.tp2.Modele.Emprunteur;
import ca.cal.tp2.Modele.Amende;

public record EmprunteurDTO(String nom, String email, String phone, List<Amende> amendes) {

    public static EmprunteurDTO toDTO(Emprunteur emprunteur) {
        return new EmprunteurDTO(emprunteur.getNom(), emprunteur.getEmail(), emprunteur.getPhone(), emprunteur.getAmendes());
    }

    public static Emprunteur toModele(EmprunteurDTO emprunteur) {
        return new Emprunteur(emprunteur.nom(), emprunteur.email(), emprunteur.phone(), emprunteur.amendes());
    }
}
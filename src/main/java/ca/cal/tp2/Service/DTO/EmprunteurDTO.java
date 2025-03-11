package ca.cal.tp2.Service.DTO;

import java.util.List;

import ca.cal.tp2.Modele.Emprunteur;
import ca.cal.tp2.Modele.Amende;
import ca.cal.tp2.Modele.Emprunt;

public record EmprunteurDTO(String nom, String email, String phone, List<Amende> amendes, List<Emprunt> emprunts) {

    public static EmprunteurDTO toDTO(Emprunteur emprunteur) {
        return new EmprunteurDTO(emprunteur.getNom(), emprunteur.getEmail(), emprunteur.getPhone(), emprunteur.getAmendes(), emprunteur.getEmprunts());
    }

    public static Emprunteur toModele(EmprunteurDTO emprunteur) {
        return new Emprunteur(emprunteur.nom(), emprunteur.email(), emprunteur.phone(), emprunteur.amendes(), emprunteur.emprunts());
    }
}
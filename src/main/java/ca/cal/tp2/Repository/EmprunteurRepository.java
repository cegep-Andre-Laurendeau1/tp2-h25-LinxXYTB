package ca.cal.tp2.Repository;

import ca.cal.tp2.BDException;
import ca.cal.tp2.Modele.Emprunteur;

public interface EmprunteurRepository {
    void save(Emprunteur emprunteur) throws BDException;
    Emprunteur getEmprunteur(String nom) throws BDException;
}

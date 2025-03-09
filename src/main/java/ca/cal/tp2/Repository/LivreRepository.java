package ca.cal.tp2.Repository;

import ca.cal.tp2.BDException;
import ca.cal.tp2.Modele.Livre;

public interface LivreRepository {
    void save(Livre livre) throws BDException;
}   
package ca.cal.tp2.Repository;

import ca.cal.tp2.BDException;
import ca.cal.tp2.Modele.DVD;

public interface DVDRepository {
    void save(DVD dvd) throws BDException;
}

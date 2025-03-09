package ca.cal.tp2.Repository;

import ca.cal.tp2.BDException;
import ca.cal.tp2.Modele.CD;

public interface CDRepository {
    void save(CD cd) throws BDException;
}

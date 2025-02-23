package ca.cal.tp2.Repository;

import ca.cal.tp2.Modele.Amende;

public interface AmendeRepository {
    void save(Amende amende);
    Amende getAmende(int id);
}

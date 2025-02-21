package ca.cal.tp1.Repository;

import ca.cal.tp1.Modele.Amende;

public interface AmendeRepository {
    void save(Amende amende);
    Amende getAmende(int id);
}

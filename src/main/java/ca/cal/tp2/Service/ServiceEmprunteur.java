package ca.cal.tp2.Service;

import java.sql.Date;

import ca.cal.tp2.Modele.Amende;
import ca.cal.tp2.Repository.AmendeRepositoryJDBC;

public class ServiceEmprunteur {
    private final AmendeRepositoryJDBC amandeRepository;

    public ServiceEmprunteur(AmendeRepositoryJDBC amandeRepository) {
        this.amandeRepository = amandeRepository;
    }

    public void createAmande(int id, double montant, Date date, boolean paye) {
        amandeRepository.save(new Amende(id, montant, date, paye));
    }

    public Amende get(int id) {
        return amandeRepository.getAmende(id);
    }
    
}

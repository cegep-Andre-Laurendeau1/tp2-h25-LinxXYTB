package ca.cal.tp2.Service;

import java.time.LocalDate;

import ca.cal.tp2.Modele.Amende;
import ca.cal.tp2.Repository.AmendeRepository;
import ca.cal.tp2.Repository.AmendeRepositoryJDBC;

public class ServiceEmprunteur {
    private final AmendeRepository amandeRepository;

    public ServiceEmprunteur(AmendeRepositoryJDBC amandeRepository) {
        this.amandeRepository = amandeRepository;
    }

    public void createAmande(int id, double montant, LocalDate date, boolean paye) {
        amandeRepository.save(new Amende(id, montant, date, paye));
    }

    public Amende get(int id) {
        return amandeRepository.getAmende(id);
    }
    
}

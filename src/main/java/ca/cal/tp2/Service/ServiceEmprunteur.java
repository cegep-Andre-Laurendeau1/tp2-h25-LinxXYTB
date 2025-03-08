package ca.cal.tp2.Service;

import java.time.LocalDate;

import ca.cal.tp2.BDException;
import ca.cal.tp2.Modele.Amende;
import ca.cal.tp2.Modele.Emprunteur;
import ca.cal.tp2.Repository.AmendeRepository;
import ca.cal.tp2.Repository.AmendeRepositoryJDBC;
import ca.cal.tp2.Repository.EmprunteurRepository;
import ca.cal.tp2.Service.DTO.AmendeDTO;
import ca.cal.tp2.Service.DTO.EmprunteurDTO;

public class ServiceEmprunteur {
        private final AmendeRepository amandeRepository;
        private final EmprunteurRepository emprunteurRepository;
    
        public ServiceEmprunteur(AmendeRepositoryJDBC amandeRepository, EmprunteurRepository emprunteurRepository) {
            this.amandeRepository = amandeRepository;
            this.emprunteurRepository = emprunteurRepository;
        }
    
        public void createAmande(int id, double montant, LocalDate date, boolean paye, EmprunteurDTO emprunteur) {
            amandeRepository.save(new Amende(id, montant, date, paye, EmprunteurDTO.toModele(emprunteur)));
        }
    
        public AmendeDTO getAmende(int id) {
            return AmendeDTO.toDTO(amandeRepository.getAmende(id));
        }
    
        public void createEmprunteur( String nom, String email, String phone) throws BDException {
            try {
                emprunteurRepository.save(new Emprunteur(nom, email, phone, null));
            } catch (Exception e) {
                throw new BDException(e.getMessage());    
            }
        }

        public EmprunteurDTO getEmprunteur(String nom) throws BDException {
            try {
                return EmprunteurDTO.toDTO(emprunteurRepository.getEmprunteur(nom));
            } catch (BDException e) {
               throw new BDException(e.getMessage());
            }
        }
    
}

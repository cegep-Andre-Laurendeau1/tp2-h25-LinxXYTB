package ca.cal.tp2.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ca.cal.tp2.BDException;
import ca.cal.tp2.NotInStockException;
import ca.cal.tp2.Modele.Amende;
import ca.cal.tp2.Modele.Document;
import ca.cal.tp2.Modele.Emprunteur;
import ca.cal.tp2.Repository.AmendeRepository;
import ca.cal.tp2.Repository.AmendeRepositoryJDBC;
import ca.cal.tp2.Repository.DocumentRepository;
import ca.cal.tp2.Repository.EmpruntRepository;
import ca.cal.tp2.Repository.EmprunteurRepository;
import ca.cal.tp2.Service.DTO.AmendeDTO;
import ca.cal.tp2.Service.DTO.DocumentDTO;
import ca.cal.tp2.Service.DTO.EmpruntDTO;
import ca.cal.tp2.Service.DTO.EmprunteurDTO;

public class ServiceEmprunteur {
    private final AmendeRepository amandeRepository;
    private final EmprunteurRepository emprunteurRepository;
    private final DocumentRepository documentRepository;
    private final EmpruntRepository emprunRepository;

    public ServiceEmprunteur(AmendeRepositoryJDBC amandeRepository, EmprunteurRepository emprunteurRepository,
            DocumentRepository documentRepository, EmpruntRepository emprunRepository) {
        this.amandeRepository = amandeRepository;
        this.emprunteurRepository = emprunteurRepository;
        this.documentRepository = documentRepository;
        this.emprunRepository = emprunRepository;
    }

    public void createAmande(int id, double montant, LocalDate date, boolean paye, EmprunteurDTO emprunteur) {
        amandeRepository.save(new Amende(id, montant, date, paye, EmprunteurDTO.toModele(emprunteur)));
    }

    public AmendeDTO getAmende(int id) {
        return AmendeDTO.toDTO(amandeRepository.getAmende(id));
    }

    public void createEmprunteur(String nom, String email, String phone) throws BDException {
        try {
            emprunteurRepository.save(new Emprunteur(nom, email, phone, null , null));
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

    public List<Document> rechercheDocument(String string) throws BDException {
        try {
            List<Document> documents = documentRepository.rechercheDocument(string);
            return documents;
        } catch (Exception e) {
            throw new BDException(e.getMessage());
        }
    }

    public void faireEmprunt(EmprunteurDTO emprunteur, List<DocumentDTO> listEmpruntDTO) throws NotInStockException, BDException {
        try {
            List<Document> documents = new ArrayList<>();
            for (DocumentDTO documentDTO : listEmpruntDTO) {
                documents.add(documentRepository.getDocument(documentDTO.titre()));
            }
            List<Document> documentsInStock = new ArrayList<>();
            for (Document document : documents) {
                if (document.getNombreExemplaires() >= 0) {
                    document.setNombreExemplaires(document.getNombreExemplaires() - 1);
                    documentsInStock.add(document);
                } else {
                    throw new NotInStockException("Document not in stock");
                }
            }
            emprunRepository.emprunterDocument(EmprunteurDTO.toModele(emprunteur), documentsInStock);
        } catch (Exception e) {
            throw new BDException(e.getMessage());
        }
    }

    public List<EmpruntDTO> afficherEmprunts(String nom) throws BDException {
        try {
           return emprunRepository.getEmpruntDeEmprunteur(nom).stream()
                .map(EmpruntDTO::toDTO)
                .toList();
        } catch (Exception e) {
            throw new BDException(e.getMessage());
        }
        
    }
}

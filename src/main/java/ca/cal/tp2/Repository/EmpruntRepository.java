package ca.cal.tp2.Repository;

import java.util.List;

import ca.cal.tp2.BDException;
import ca.cal.tp2.Modele.Document;
import ca.cal.tp2.Modele.Emprunt;
import ca.cal.tp2.Modele.Emprunteur;

public interface EmpruntRepository {
    void save(Emprunt emprunt) throws BDException;

    void emprunterDocument(Emprunteur modele, List<Document> documents) throws BDException;

    List<Emprunt> getEmpruntDeEmprunteur(String string) throws BDException;
}

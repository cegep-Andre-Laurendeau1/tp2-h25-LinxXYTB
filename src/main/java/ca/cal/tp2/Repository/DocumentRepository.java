package ca.cal.tp2.Repository;

import java.util.List;

import ca.cal.tp2.BDException;
import ca.cal.tp2.Modele.Document;

public interface DocumentRepository {
    List<Document> rechercheDocument(String string) throws BDException;
}

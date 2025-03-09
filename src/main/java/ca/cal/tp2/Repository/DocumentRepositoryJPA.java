package ca.cal.tp2.Repository;

import java.util.List;

import ca.cal.tp2.BDException;
import ca.cal.tp2.Modele.Document;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class DocumentRepositoryJPA extends RepositoryParentJPA implements DocumentRepository {

    @Override
    public List<Document> rechercheDocument(String titre) throws BDException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            TypedQuery<Document> query = em.createQuery(
                "SELECT d FROM Document d WHERE d.titre LIKE :title", 
                Document.class);
            query.setParameter("title", titre );
            List<Document> documents = query.getResultList();
            em.getTransaction().commit();
            return documents;
        } catch (Exception e) {
            throw new BDException(e.getMessage());
        }
    }

}

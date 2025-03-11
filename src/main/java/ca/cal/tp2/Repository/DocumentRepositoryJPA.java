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
                "SELECT d FROM Document d WHERE LOWER(d.titre) LIKE LOWER(:title)", 
                Document.class);
            query.setParameter("title", titre );
            List<Document> documents = query.getResultList();
            documents.forEach(d -> d.getEmpruntDetails().size());
            em.getTransaction().commit();
            return documents;
        } catch (Exception e) {
            throw new BDException(e.getMessage());
        }
    }

    @Override
    public Document getDocument(String nom) throws BDException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            TypedQuery<Document> query = em.createQuery(
                "SELECT d FROM Document d WHERE LOWER(d.titre) = LOWER(:nom)", 
                Document.class);
            query.setParameter("nom", nom);
            Document document = query.getSingleResult();
            document.getEmpruntDetails().size();
            em.getTransaction().commit();
            return document;
        } catch (Exception e) {
            throw new BDException(e.getMessage());
        }
    }

}

package ca.cal.tp2.Repository;

import ca.cal.tp2.BDException;
import ca.cal.tp2.Modele.Livre;
import jakarta.persistence.EntityManager;

public class LivreRepositoryJPA extends RepositoryParentJPA implements LivreRepository {

    @Override
    public void save(Livre livre) throws BDException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(livre);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new BDException(e.getMessage());
        }
    }

}

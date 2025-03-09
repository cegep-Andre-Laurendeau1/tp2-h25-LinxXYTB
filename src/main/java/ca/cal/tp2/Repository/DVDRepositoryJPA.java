package ca.cal.tp2.Repository;

import ca.cal.tp2.BDException;
import ca.cal.tp2.Modele.DVD;
import jakarta.persistence.EntityManager;

public class DVDRepositoryJPA extends RepositoryParentJPA implements DVDRepository {

    @Override
    public void save(DVD dvd) throws BDException {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(dvd);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new BDException(e.getMessage());
        }
    }

}

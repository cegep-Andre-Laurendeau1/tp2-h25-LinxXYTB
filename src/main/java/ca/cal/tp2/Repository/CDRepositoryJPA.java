package ca.cal.tp2.Repository;

import ca.cal.tp2.BDException;
import ca.cal.tp2.Modele.CD;
import jakarta.persistence.EntityManager;

public class CDRepositoryJPA extends RepositoryParentJPA implements CDRepository {

    @Override
    public void save(CD cd) throws BDException {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(cd);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new BDException(e.getMessage());
        }
    }

}

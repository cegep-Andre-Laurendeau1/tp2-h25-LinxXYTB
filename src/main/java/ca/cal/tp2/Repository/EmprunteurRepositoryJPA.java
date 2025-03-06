package ca.cal.tp2.Repository;

import ca.cal.tp2.BDException;
import ca.cal.tp2.Modele.Emprunteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


public class EmprunteurRepositoryJPA extends RepositoryParentJPA implements EmprunteurRepository {

    @Override
    public void save(Emprunteur emprunteur) {
        try(EntityManager em = emf.createEntityManager()) {
        em.getTransaction().begin();
        em.persist(emprunteur);
        em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Emprunteur getEmprunteur(String nom) throws BDException {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Emprunteur> query = em.createQuery("SELECT e FROM Emprunteur e WHERE e.nom = :nom", Emprunteur.class);
            query.setParameter("nom", nom);
            Emprunteur emprunteur = query.getSingleResult();
            emprunteur.getAmendes().size();
            return emprunteur;
        } catch (Exception e) {
            throw new BDException(e.getMessage());
        }
    }

}

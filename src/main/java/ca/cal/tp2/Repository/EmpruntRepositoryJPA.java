package ca.cal.tp2.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ca.cal.tp2.BDException;
import ca.cal.tp2.Modele.CD;
import ca.cal.tp2.Modele.Document;
import ca.cal.tp2.Modele.Emprunt;
import ca.cal.tp2.Modele.EmpruntDetail;
import ca.cal.tp2.Modele.Emprunteur;
import ca.cal.tp2.Modele.Livre;
import jakarta.persistence.EntityManager;

public class EmpruntRepositoryJPA extends RepositoryParentJPA implements EmpruntRepository {

    @Override
    public void save(Emprunt emprunt) throws BDException {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(emprunt);
            em.getTransaction().commit();
        }catch (Exception e) {
            throw new BDException(e.getMessage());
        }
    }

    @Override
    public void emprunterDocument(Emprunteur modele, List<Document> documents) throws BDException {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            Emprunt emprunt = new Emprunt();
            List<EmpruntDetail> empruntDetails = new ArrayList<>();
            documents.forEach(d -> {
                LocalDate date = null;
                if (d instanceof Livre) {
                    date = LocalDate.now().plusDays(21);
                } else if(d instanceof CD) {
                    date = LocalDate.now().plusDays(14);
                } else {
                    date = LocalDate.now().plusDays(7);
                }
                empruntDetails.add(new EmpruntDetail( date, null, "En cours", emprunt, d));
            });
            emprunt.setDateEmprunt(LocalDate.now());
            emprunt.setStatus("En cours");
            emprunt.setEmpruntDetail(empruntDetails);
            emprunt.setEmprunteur(modele);
            em.persist(emprunt);
            em.getTransaction().commit();
        }catch (Exception e) {
            throw new BDException(e.getMessage());
        }
    }

    @Override
    public List<Emprunt> getEmpruntDeEmprunteur(String string) throws BDException {
        try(EntityManager em = emf.createEntityManager()){
            List<Emprunt> emprunts = em.createQuery("SELECT e FROM Emprunt e WHERE e.emprunteur.nom = :nom", Emprunt.class)
                    .setParameter("nom", string)
                    .getResultList();
            emprunts.forEach(e -> e.getEmpruntDetail().size());
            return emprunts;
        }catch (Exception e) {
            throw new BDException(e.getMessage());
        }
    }

}

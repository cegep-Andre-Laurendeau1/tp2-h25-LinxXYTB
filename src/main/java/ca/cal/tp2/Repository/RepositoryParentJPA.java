package ca.cal.tp2.Repository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class RepositoryParentJPA {
    
    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2iulianmoraru");

}

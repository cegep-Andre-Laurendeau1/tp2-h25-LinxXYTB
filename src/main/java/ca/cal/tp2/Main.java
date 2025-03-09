package ca.cal.tp2;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import ca.cal.tp2.Modele.Document;
import ca.cal.tp2.Repository.AmendeRepositoryJDBC;
import ca.cal.tp2.Repository.CDRepositoryJPA;
import ca.cal.tp2.Repository.DVDRepositoryJPA;
import ca.cal.tp2.Repository.DocumentRepositoryJPA;
import ca.cal.tp2.Repository.EmprunteurRepositoryJPA;
import ca.cal.tp2.Repository.LivreRepositoryJPA;
import ca.cal.tp2.Service.ServiceEmprunteur;
import ca.cal.tp2.Service.ServicePreposer;
import ca.cal.tp2.Service.DTO.CDDTO;
import ca.cal.tp2.Service.DTO.LivreDTO;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {

        TcpServer.startTcpServer();

        final ServiceEmprunteur ServiceEmprunteur = new ServiceEmprunteur(new AmendeRepositoryJDBC(), new EmprunteurRepositoryJPA(), new DocumentRepositoryJPA());
        final ServicePreposer ServicePreposer = new ServicePreposer(new LivreRepositoryJPA(), new CDRepositoryJPA(), new DVDRepositoryJPA());

        try {
            ServiceEmprunteur.createEmprunteur("Iulian", "iulianlebg@gmail.com", "514-114-7747");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(ServiceEmprunteur.getEmprunteur("Iulian"));
        } catch (BDException e) {
            System.out.println(e.getMessage());
        }

        try {
            ServiceEmprunteur.createAmande(1, 1.25, LocalDate.of(2025, 1, 1) , true, ServiceEmprunteur.getEmprunteur("Iulian"));
        } catch (BDException e) {
            System.out.println(e.getMessage());
        }

        try {
            ServicePreposer.saveLivre(new LivreDTO("Les parapluis qui chante le ciel", 2, "995456-55556-55652", "Didi", "avanture", 2000));
        } catch (BDException e) {
            System.out.println(e.getMessage());
        }

        try {
            ServicePreposer.saveCD(new CDDTO("Les parapluis de midi", 1, "Gustave", "Romance", 2000));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
           List<Document> documents = ServiceEmprunteur.rechercheDocument("parapluis");
           if (documents.isEmpty()) {
               System.out.println("No documents found");
           } else {
               documents.forEach(System.out::println);
           }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
        System.out.println(ServiceEmprunteur.getAmende(1));
        Thread.currentThread().join();
    }
}

package ca.cal.tp2;


import java.sql.SQLException;
import java.time.LocalDate;

import ca.cal.tp2.Repository.AmendeRepositoryJDBC;
import ca.cal.tp2.Service.ServiceEmprunteur;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {

        TcpServer.startTcpServer();

        final ServiceEmprunteur ServiceEmprunteur = new ServiceEmprunteur(new AmendeRepositoryJDBC());

        ServiceEmprunteur.createAmande(1, 1.25, LocalDate.of(2025, 1, 1) , true);

        System.out.println(ServiceEmprunteur.get(1));
        Thread.currentThread().join();

    }
}

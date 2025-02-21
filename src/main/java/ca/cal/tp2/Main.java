package ca.cal.tp1;

import java.sql.Date;
import java.sql.SQLException;

import ca.cal.tp1.Repository.AmendeRepositoryJDBC;
import ca.cal.tp1.Service.ServiceEmprunteur;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {

        TcpServer.startTcpServer();

        final ServiceEmprunteur ServiceEmprunteur = new ServiceEmprunteur(new AmendeRepositoryJDBC());

        ServiceEmprunteur.createAmande(1, 1.25, Date.valueOf("2021-10-10"), true);

        System.out.println(ServiceEmprunteur.get(1));
        Thread.currentThread().join();

    }
}

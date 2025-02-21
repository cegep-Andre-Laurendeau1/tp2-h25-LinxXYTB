package ca.cal.tp1.Modele;

import java.sql.Date;

import lombok.Data;

@Data
public class Amende {
    private final int fineID;
    private final double montant;
    private final Date dateCreation;
    private final boolean status;
    
    public void calculerAmende() {
        System.out.println("Calculer amende");
    }

    public void updateStatus() {
        System.out.println("Update status");
    }
}

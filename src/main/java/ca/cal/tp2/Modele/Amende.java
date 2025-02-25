package ca.cal.tp2.Modele;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Amende {
    private final int fineID;
    private final double montant;
    private final LocalDate dateCreation;
    private final boolean status;
    
    public void calculerAmende() {
        System.out.println("Calculer amende");
    }

    public void updateStatus() {
        System.out.println("Update status");
    }
}
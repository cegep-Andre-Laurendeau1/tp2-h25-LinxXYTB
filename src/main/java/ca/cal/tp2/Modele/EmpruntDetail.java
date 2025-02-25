package ca.cal.tp2.Modele;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmpruntDetail {
    private final int lineItemID;
    private final LocalDate dateRetrourPrevu;
    private final LocalDate dateRetourActuelle;
    private final String status;

    public boolean isEnRetard() {
        return false;
    }

    public void calculerAmende() {
        System.out.println("Calculer amende");
    }

    public void updateStatus() {
        System.out.println("Update status");
    }
}

package ca.cal.tp1.Modele;

import java.util.Date;

import lombok.Data;

@Data
public class EmpruntDetail {
    private final int lineItemID;
    private final Date dateRetrourPrevu;
    private final Date dateRetourActuelle;
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

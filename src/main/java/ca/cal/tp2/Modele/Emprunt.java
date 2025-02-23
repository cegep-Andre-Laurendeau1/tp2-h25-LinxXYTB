package ca.cal.tp2.Modele;

import java.util.Date;

import lombok.Data;

@Data
public class Emprunt {
    private final int borrowID;
    private final Date dateEmprunt;
    private final boolean status;

    public void getItems() {
        System.out.println("Get items");
    }
}

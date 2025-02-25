package ca.cal.tp2.Modele;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Emprunt {
    private final int borrowID;
    private final LocalDate dateEmprunt;
    private final boolean status;

    public void getItems() {
        System.out.println("Get items");
    }
}

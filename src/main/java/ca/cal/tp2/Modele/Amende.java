package ca.cal.tp2.Modele;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Amende {
    @Id
    private int fineID;
    private double montant;
    private LocalDate dateCreation;
    private boolean status;
    
    public void calculerAmende() {
        System.out.println("Calculer amende");
    }

    public void updateStatus() {
        System.out.println("Update status");
    }
}
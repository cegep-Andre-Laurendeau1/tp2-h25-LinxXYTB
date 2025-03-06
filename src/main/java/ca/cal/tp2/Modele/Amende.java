package ca.cal.tp2.Modele;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private double montant;
    private LocalDate dateCreation;
    private boolean status;
    @ManyToOne
    private Emprunteur emprunteur;
    
    public void calculerAmende() {
        System.out.println("Calculer amende");
    }

    public void updateStatus() {
        System.out.println("Update status");
    }
}
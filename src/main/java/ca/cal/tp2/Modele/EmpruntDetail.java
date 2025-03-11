package ca.cal.tp2.Modele;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EmpruntDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private LocalDate dateRetrourPrevu;
    private LocalDate dateRetourActuelle;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    Emprunt emprunt;

    @ManyToOne(fetch = FetchType.LAZY)
    Document document;

    public EmpruntDetail(LocalDate dateRetrourPrevu, LocalDate dateRetourActuelle, String status, Emprunt emprunt, Document document) {
        this.dateRetrourPrevu = dateRetrourPrevu;
        this.dateRetourActuelle = dateRetourActuelle;
        this.status = status;
        this.emprunt = emprunt;
        this.document = document;
    }

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

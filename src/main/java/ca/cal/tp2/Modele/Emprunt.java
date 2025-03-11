package ca.cal.tp2.Modele;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private LocalDate dateEmprunt;
    private String status;

    @OneToMany(mappedBy = "emprunt", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<EmpruntDetail> empruntDetail;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Emprunteur emprunteur;

    public Emprunt(LocalDate dateEmprunt, String status, List<EmpruntDetail> empruntDetail, Emprunteur emprunteur) {
        this.dateEmprunt = dateEmprunt;
        this.status = status;
        this.empruntDetail = empruntDetail;
        this.emprunteur = emprunteur;
    }

    public void getItems() {
        System.out.println("Get items");
    }
}

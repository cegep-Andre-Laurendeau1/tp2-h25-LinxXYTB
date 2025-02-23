package ca.cal.tp2.Modele;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public abstract class Utilisateur {
    private final int UserID;
    private final String name;
    private final String email;
    private final String phoneNumber;

    public void login() {
        System.out.println("Login");
    }
}

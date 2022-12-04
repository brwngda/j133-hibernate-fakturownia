package pl.sda.hibernate.fakturownia;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Firma;

public class Main {
    public static void main(String[] args) {
        // SELECT * FROM firma;
        new DataAccessObject<Firma>().findAll(Firma.class);
    }
}

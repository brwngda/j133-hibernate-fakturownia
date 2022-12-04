package pl.sda.hibernate.fakturownia;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.komenda.Komenda;
import pl.sda.hibernate.fakturownia.komenda.KomendaDodajFirme;
import pl.sda.hibernate.fakturownia.model.Firma;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//   sposób na sprawdzenie zgodności ustawień początkowych (modeli, relacji, itd.)
//   SELECT * FROM firma;
//   new DataAccessObject<Firma>().findAll(Firma.class);

        List<Komenda> listaKomend = List.of(
                new KomendaDodajFirme()
        );

        String komenda;
        do {
            System.out.println("Lista dostępnych komend:");
            for (int i = 0; i < listaKomend.size(); i++) {
                // wiersz po wierszu wypiszą się komendy w formie:
                // 1. dodaj X
                // 2. dodaj y ...
                System.out.println((i + 1) + ". " + listaKomend.get(i).getKomenda());
            }
            ;
            System.out.println(); // pusta nowa linia, która oddziela porzednią listę

            System.out.println("Podaj komende:");
            komenda = Komenda.scanner.nextLine();

            for (Komenda dostepnaKomenda : listaKomend) {
                if (dostepnaKomenda.getKomenda().equals(komenda)) {
                    dostepnaKomenda.obsluga();
                }
            }
        } while (!komenda.equalsIgnoreCase("exit"));
    }
}

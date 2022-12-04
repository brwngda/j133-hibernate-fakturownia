package pl.sda.hibernate.fakturownia.komenda;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Firma;

public class KomendaDodajFirme implements Komenda {
    private DataAccessObject<Firma> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj firme";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj nazwe firmy:");
        String nazwa = Komenda.scanner.nextLine();

        System.out.println("Podaj NIP firmy:");
        String nip = Komenda.scanner.nextLine();

        System.out.println("Podaj adres firmy:");
        String adres = Komenda.scanner.nextLine();

        Firma firma = Firma.builder()
                .nazwa(nazwa)
                .nip(nip)
                .adres(adres)
                .build();

        dao.insert(firma);
    }
}

package pl.sda.hibernate.fakturownia.komenda;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Firma;
import pl.sda.hibernate.fakturownia.model.Kontrahent;

public class KomendaDodajKontrahenta implements Komenda {
    private DataAccessObject<Kontrahent> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj kontrahenta";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj nazwe kontrahenta:");
        String nazwa = Komenda.scanner.nextLine();

        System.out.println("Podaj NIP kontrahenta:");
        String nip = Komenda.scanner.nextLine();

        System.out.println("Podaj adres kontrahenta:");
        String adres = Komenda.scanner.nextLine();

        Kontrahent kontrahent = Kontrahent.builder()
                .nazwa(nazwa)
                .nip(nip)
                .adres(adres)
                .build();

        dao.insert(kontrahent);
    }
}

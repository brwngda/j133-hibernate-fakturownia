package pl.sda.hibernate.fakturownia.komenda;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Faktura;
import pl.sda.hibernate.fakturownia.model.FormaPlatnosci;
import pl.sda.hibernate.fakturownia.model.Platnosc;

public class KomendaDodajPlatnosc implements Komenda {
    private DataAccessObject<Platnosc> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj platnosc";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj forme platnosci (:");
        String formaPlatnosciString = Komenda.scanner.nextLine();
        FormaPlatnosci formaPlatnosci = FormaPlatnosci.valueOf(formaPlatnosciString);


        System.out.println("Podaj kwote:");
        String kwotaString = Komenda.scanner.nextLine();
        Double kwota = Double.parseDouble(kwotaString);

        Platnosc platnosc = Platnosc.builder()
                .formaPlatnosci(formaPlatnosci)
                .kwota(kwota)
                .build();

        dao.insert(platnosc);
    }
}

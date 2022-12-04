package pl.sda.hibernate.fakturownia.komenda;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Faktura;
import pl.sda.hibernate.fakturownia.model.Firma;

import java.time.LocalDate;

public class KomendaDodajFaktura implements Komenda {
    private DataAccessObject<Faktura> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj faktura";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj numer faktury:");
        String numerFaktury = Komenda.scanner.nextLine();

        System.out.println("Podaj termin platnosci (YYYY-MM-DD)");
        String dataTerminPlatnosciString = Komenda.scanner.nextLine();
        LocalDate dataTerminPlatnosci = LocalDate.parse(dataTerminPlatnosciString);

        System.out.println("Podaj kwote faktury:");
        String kwotaString = Komenda.scanner.nextLine();
        Double kwota = Double.parseDouble(kwotaString);

        Faktura faktura = Faktura.builder()
                .numerFaktury(numerFaktury)
                .kwota(kwota)
                .dataTerminPlatnosci(dataTerminPlatnosci)
                .build();

        dao.insert(faktura);
    }
}

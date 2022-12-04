package pl.sda.hibernate.fakturownia.Komendy;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Faktura;

public class KomendaDodajFaktura implements Komenda {
    private DataAccessObject<Faktura> dataAccessObject;

    public KomendaDodajFaktura() {
        this.dataAccessObject = new DataAccessObject<>();
    }


    @Override
    public String getKomenda() {
        return "dodaj faktura";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj numer faktury");
        String numerFaktury = Komenda.scanner.nextLine();

        System.out.println("Podaj kwote");
        String kwotaString = Komenda.scanner.nextLine();
        Double kwota = Double.parseDouble(kwotaString);

        System.out.println("Podaj specjalizacje");
        String specjalizacja = Komenda.scanner.nextLine();

        Faktura faktura = Faktura.builder()
                .numerFaktury(numerFaktury)
                .kwota(kwota)
                .build();

        dataAccessObject.insert(faktura);
    }
}

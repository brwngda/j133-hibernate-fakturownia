package pl.sda.hibernate.fakturownia.komenda;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Firma;

import java.util.List;

public class KomendaUsunFirma implements Komenda {
    private DataAccessObject<Firma> dao;

    @Override
    public String getKomenda() {
        return "usun firma";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego pojazdu:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dao.delete(Firma.class, id)) {
            System.out.println("Usunięto firme");
        } else {
            System.err.println("Nie udało się usunąć firmy");
        }
    }
}
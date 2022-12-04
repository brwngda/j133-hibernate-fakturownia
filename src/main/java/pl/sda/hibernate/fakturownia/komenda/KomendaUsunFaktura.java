package pl.sda.hibernate.fakturownia.komenda;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Faktura;
import pl.sda.hibernate.fakturownia.model.Firma;

public class KomendaUsunFaktura implements Komenda {
    private DataAccessObject<Faktura> dao;

    @Override
    public String getKomenda() {
        return "usun fakture";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego faktury:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dao.delete(Faktura.class, id)) {
            System.out.println("Usunięto fakture");
        } else {
            System.err.println("Nie udało się usunąć faktury");
        }
    }
}